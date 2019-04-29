package com.easydev.myrule;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.Server;
import java.util.List;
import java.util.Random;

public class RandomRule_Easy extends RandomRule {

    Random random = new Random();
    private int total = 0;
    private int curIndex = 0;

    /**
     * Randomly choose from all living servers
     */
    @Override
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;



        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

            int index = random.nextInt(serverCount);
            if (total < 3) {
                total++;
                index = curIndex;
            } else {
                curIndex = random.nextInt(serverCount);
                System.out.println("newCurIndex : " + curIndex);
                total = 1;
                index = curIndex;
            }
            System.out.println("index : " + index);
            server = upList.get(index);

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }
}