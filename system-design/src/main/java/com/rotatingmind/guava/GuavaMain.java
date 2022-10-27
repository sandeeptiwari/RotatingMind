package com.rotatingmind.guava;

import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.Service;

import java.util.concurrent.Executor;

public class GuavaMain {

    public static void main(String[] args) {
        Runnable RunnableTask1 = () -> {
            System.out.println("Task-1 ");
        };
        Runnable RunnableTask2 = () -> {
            System.out.println("Task-2 ");
        };

        Executor executor = new DirectExecutor();
       // executor.execute(RunnableTask1);
       // executor.execute(RunnableTask2);

        ProcessService service = new ProcessService();
        service.addListener(new Service.Listener() {
            @Override
            public void starting() {
                super.starting();
                System.out.println("Start");
            }

            @Override
            public void running() {
                super.running();
                System.out.println("running");
            }

            @Override
            public void stopping(Service.State from) {
                super.stopping(from);
                System.out.println("stopping");
            }

            @Override
            public void terminated(Service.State from) {
                super.terminated(from);
                System.out.println("terminated");
            }

            @Override
            public void failed(Service.State from, Throwable failure) {
                super.failed(from, failure);
                System.out.println("failed");
            }
        }, executor);
        service.startAsync();
    }

   private static class DirectExecutor implements Executor {
        public void execute(Runnable r) {
            r.run();
        }
    }
}

class ProcessService extends AbstractService {

    public ProcessService() {
        super();
    }

    @Override
    protected void doStart() {
        System.out.println("doStart");
        start();
    }

    @Override
    protected void doStop() {
        System.out.println("doStop");
    }

    public void start() {
        notifyStarted();
    }

    /*@Override
    public void starting() {
        super.starting();
        System.out.println("Start");
    }

    @Override
    public void running() {
        super.running();
        System.out.println("running");
    }

    @Override
    public void stopping(Service.State from) {
        super.stopping(from);
        System.out.println("stopping");
    }

    @Override
    public void terminated(Service.State from) {
        super.terminated(from);
        System.out.println("terminated");
    }

    @Override
    public void failed(Service.State from, Throwable failure) {
        super.failed(from, failure);
        System.out.println("failed");
    }*/
}
