package com.lan.future;

import java.util.concurrent.*;

/**
 * @author jianglin.lan
 * @title: ThreadTest
 * @projectName study-day
 * @description: TODO
 * @date 2021/4/2918:57
 */

public class ThreadTest {

    public static ExecutorService service = new ThreadPoolExecutor (10,
            30, 3L, TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable> (100), Executors.defaultThreadFactory (),
            new ThreadPoolExecutor.AbortPolicy ());

    public static void main (String[] args) throws ExecutionException, InterruptedException {
        //当前系统中池只有一两个，每个异步任务，提交给线程池让其自己去执行
        System.out.println ("main....start.......");
        /*
         * 1）.集成Thread 类
         *       Thread01 thread = new Thread01 ();
         *       thread.start ();
         * 2）、实现Runnbale接口
         *          Runnable01 runnable01 = new Runnable01 ();
         *          new Thread (runnable01).start ();
         * 3）、实现Callable 接口 + FutureTask(可获取返回结果，可处理异常)
         *         FutureTask<Integer> futureTask = new FutureTask<> (new Callable01 ());
         *         new Thread (futureTask).start ();
         *         //阻塞等待整个县城执行完成，获取返回结果
         *         Integer integer = futureTask.get ();
         * 4）、线程池
         *      给线程池直接提交任务
         *              ExecutorService service = Executors.newFixedThreadPool (10);
         *              service.execute (new Runnable01 ());
         *      1、创建
         *          1）、Executors
         *          2）、 new ThreadPoolExecutor
         *
         *区别：
         *      1、2不能获取到返回值。3可以获取到返回值
         *      4可以控制资源，性能稳定
         *
         */
        /* *****************************************************************************/
        /*
         * 七大参数：
         *  corePoolSize：核心线程数【一直存在，除非（allowCoreThreadTimeOut）】；线程池创建好了就准备就绪的线程数量，就等待来接受异步任务来执行
         *  maximumPoolSize：最大线程数；控制资源
         *  keepAliveTime：存活时间。如果当前线程数量大于核心线程数量（corePoolSize）。
         *      只要线程空闲时间大于指定的keepAliveTime，释放空闲的线程（maximumPoolSize-corePoolSize）
         *  unit：时间单位
         *  BlockingQueue<Runnable> workQueue：阻塞队列。如果任务有很多，就会将目前多的任务放入队列。
         *      只要有线程空闲，就会去队列里面取出新的任务继续执行
         *  threadFactory：线程的创建工厂
         *  RejectedExecutionHandler handler：如果队列满了，按照我们指定的拒绝策略拒绝执行任务
         *
         ** ThreadPoolExecutor(int corePoolSize,
         *                     int maximumPoolSize,
         *                     long keepAliveTime,
         *                     TimeUnit unit,
         *                     BlockingQueue<Runnable> workQueue,
         *                     ThreadFactory threadFactory,
         *                     RejectedExecutionHandler handler)
         *
         *
         * 工作顺序：
         *  1、线程池创建，准备好core数量的核心线程，准备接受任务
         *  2、新的任务进来，用core准备好的空闲线程执行。
         *      1）、core满了、就将再进来的的任务放入阻塞队列中。空闲的core就会自己取阻塞队列中获取任务执行
         *      2）、阻塞队列满了、就直接开新线程执行，最大只能开大max指定的数量
         *      2）、max都执行完成。max - core数量空闲的线程会在不keepLiveTime指定的时间后自动销毁，最终保持到core大小
         *      4）、如果线程数开大了max的数量，还有新的任务进来，就会使用RejectedExecutionHandler指定的拒绝策略进行处理
         *  3、所有的线程创建都是由指定的factor创建的
         *
         */
        /*new ThreadPoolExecutor(5 ,
        200,
        10,
        TimeUnit.SECONDS,
        new LinkedBlockingQueue<> (10000),
        Executors.defaultThreadFactory (),
       new ThreadPoolExecutor.AbortPolicy ());*/
        /* *****************************************************************************/

        /*
         * CompletableFuture 提供了四个静态方法来创建一个异步操作  以异步的方式创建线程
         *   1、public static CompletableFuture<Void> runAsync(Runnable runnable)
         *   2、public static CompletableFuture<Void> runAsync(Runnable runnable,Executor executor)
         *   3、public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier)
         *   4、public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier,Executor executor)
         *
         *   1）、runXxxx都是没有返回结果的，supplyXxxx都是可以获取返回结果的
         *   2）、可以传入自定义的线程池，否则就用默认的线程池
         *
         */
//        CompletableFuture<Void> future = CompletableFuture.runAsync (() -> {
//            System.out.println ("当前线程：" + Thread.currentThread ().getId ());
//            int i = 10 / 2;
//            System.out.println ("运行结果:" + i);
//        }, service);

//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync (() -> {
//            System.out.println ("当前线程：" + Thread.currentThread ().getId ());
//            int i = 10 / 2;
//            System.out.println ("运行结果:" + i);
//            return i;
//        }, service);

        /* ****************************************************************************/
        /*
         *
         *  public CompletableFuture<T> whenComplete(BiConsumer<? super T, ? super Throwable> action)
         *  public CompletableFuture<T> whenCompleteAsync(BiConsumer<? super T, ? super Throwable> action)
         *  public CompletableFuture<T> whenCompleteAsync(BiConsumer<? super T, ? super Throwable> action, Executor
         * executor)
         *  public CompletableFuture<T> exceptionally(Function<Throwable, ? extends T> fn)
         *
         *  whenComplete 可以处理正常和异常的计算结果  exceptionally 处理异常情况
         *  whenComplete 和 whenCompleteAsync 的区别：
         *      whenComplete：是执行当前任务的线程继续执行 whenComplete的任务
         *      whenCompleteAsync：是执行把 whenCompleteAsync 这个任务继续提交给线程池来进行执行
         *  方法不是Async结尾，意味着Action使用相同的线程执行，而Async可能为使用其它线程执行
         *  （如果是使用相同的线程池，也可能会被同一个线程选中执行）
         *
         */
        /*
         * 方法完成后的感知
         */
//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync (() -> {
//            System.out.println ("当前线程：" + Thread.currentThread ().getId ());
//            int i = 10 / 0;
//            System.out.println ("运行结果:" + i);
//            return i;
//        }, service).whenComplete ((res, exception) -> {
//            //虽然可以得到异常信息。但是没法修改返回数据
//            System.out.println ("异步任务成功完成了。。。。结果是：" + res + "异常是：" + exception);
//        }).exceptionally (throwable -> {
//            //可以感知异常,可以返回默认值
//            return 10;
//        });
        /* *****************************************************************************/
        /*
         *  public <U> CompletableFuture<U> handle(BiFunction<? super T, Throwable, ? extends U> fn)
         *  public <U> CompletableFuture<U> handleAsync(BiFunction<? super T, Throwable, ? extends U> fn)
         *  public <U> CompletableFuture<U> handleAsync(BiFunction<? super T, Throwable, ? extends U> fn, Executor
         * executor)
         *  和complete一样，可对结果做最后的处理（可处理异常），可改变返回值
         *
         */

        /*
         * 方法完成后的处理
         */
//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync (() -> {
//            System.out.println ("当前线程：" + Thread.currentThread ().getId ());
//            int i = 10 / 4;
//            System.out.println ("运行结果:" + i);
//            return i;
//        }, service).handle ((res, thr) -> {
//            if (null != res) {
//                return res * 4;
//            }
//            if (null != thr) {
//                return 0;
//            }
//            return 0;
//        });
        //apply(T t, U u)
        /* *****************************************************************************/
        /*
         *
         *  public <U> CompletableFuture<U> thenApply(Function<? super T,? extends U> fn)
         *  public <U> CompletableFuture<U> thenApplyAsync(Function<? super T,? extends U> fn)
         *  public <U> CompletableFuture<U> thenApplyAsync(Function<? super T,? extends U> fn, Executor executor)
         *
         *  public CompletableFuture<Void> thenAccept(Consumer<? super T> action)
         *  public CompletableFuture<Void> thenAcceptAsync(Consumer<? super T> action)
         *  public CompletableFuture<Void> thenAcceptAsync(Consumer<? super T> action,Executor executor)
         *
         *  public CompletableFuture<Void> thenRun(Runnable action)
         *  public CompletableFuture<Void> thenRunAsync(Runnable action)
         *  public CompletableFuture<Void> thenRunAsync(Runnable action,Executor executor)
         *
         * thenApply 方法：当线程依赖另一个线城时，获取上一个任务返回的结果，并返回当前任务的返回值
         * thenAccept 方法：消费处理结果。接受任务的处理结果，并消费处理，无返回结果
         * thenRun 方法：只要上面的任务完成，就开始执行thenRun ,只是任务处理完后，执行thenRun的后续操作
         *  带有Async默认都是异步的。同之前。
         *  以上的都要前置任务完成
         *
         */

        /*
         * 线程串行话
         *  1）、thenRun；不能获取到上一步的执行结果
         *  2）、thenAccept；能接受上一步结果，但是无返回值
         *  3）、thenApply；能接受上一步结果，有无返回值
         */
//        CompletableFuture<Void> future = CompletableFuture.supplyAsync (() -> {
//            System.out.println ("当前线程：" + Thread.currentThread ().getId ());
//            int i = 10 / 4;
//            System.out.println ("运行结果:" + i);
//            return i;
//        }, service).thenRunAsync (() -> {
//            System.out.println ("任务thenRunAsync启动了");
//        }, service);

//        CompletableFuture<Void> future = CompletableFuture.supplyAsync (() -> {
//            System.out.println ("当前线程：" + Thread.currentThread ().getId ());
//            int i = 10 / 4;
//            System.out.println ("运行结果:" + i);
//            return i;
//        }, service).thenAcceptAsync ((res) -> {
//            System.out.println ("thenAcceptAsync");
//        }, service);

//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync (() -> {
//            System.out.println ("当前线程：" + Thread.currentThread ().getId ());
//            int i = 10 / 4;
//            System.out.println ("运行结果:" + i);
//            return i;
//        }, service).thenApplyAsync ((res) -> {
//            System.out.println ("thenAcceptAsync");
//            return res * 6;
//        }, service);

        /* ******************************************8888888888888***********************************/
        /*
         * thenCombine ；组合两个future，获取两个future的返回结果，并返回当前任务的返回值
         * thenAcceptBoth: 组合两个future,获取两个future的返回结果,然后处理任务，没有返回值
         * runAfterBoth: 组合两个future，不需要获取future的结果，只需要两个future处理完任务后，处理该任务
         *
         */

//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync (() -> {
//            System.out.println ("线程yi：" + Thread.currentThread ().getId ());
//            int i = 10 / 4;
//            System.out.println ("运行结果yi:" + i);
//            return i;
//        }, service);
//
//        CompletableFuture<String> future2 = CompletableFuture.supplyAsync (() -> {
//            System.out.println ("当前线程er：" + Thread.currentThread ().getId ());
//            int i = 10 / 4;
//            System.out.println ("运行结果er:" + i);
//            return "success";
//        }, service);

//        CompletableFuture<Void> future3 = future.runAfterBothAsync (future2, () -> {
//            System.out.println ("runAfterBothAsync开始。。。");
//        }, service);

//        CompletableFuture<Void> future3 = future.thenAcceptBothAsync (future2, (f, f2) -> {
//            System.out.println ("thenAcceptBothAsync开始。。。" + f + "《====》" + f2);
//        }, service);

//        CompletableFuture<String> future3 = future.thenCombineAsync (future2, (f, f2) -> {
//            return f + f2;
//        }, service);
//
//
//        CompletableFuture.allOf (future, future2, future3);

        /* *****************************************************************************/
        /*
         *
         * 当两个任务中，任意一个future任务完成的时候，执行任务。
         * applyToEither:两个任务有一个执行完成，获取它的返回值，处理任务 并没新的返回值
         * acceptEither:两个任务有一个执行完成，获取它的返回值，处理任务，没有新的返回值
         * runAfterEither:两个任务有一个执行完成，不需要获取future的结果，处理任务，没有新的返回值
         *
         *
         */

        /* *****************************************************************************/
        /*
         * allOf:等待所有完成
         * anyOf：任意一个完成
         *
         *          使用.get()或者.join() 方法阻塞 之后才会之后后面的逻辑
         *
         */


        System.out.println ("main....end.......");

    }

    public static class Thread01 extends Thread {
        @Override
        public void run () {
            System.out.println ("当前线程：" + Thread.currentThread ().getId ());
            int i = 10 / 2;
            System.out.println ("运行结果:" + i);
            super.run ();
        }
    }

    public static class Runnable01 implements Runnable {
        @Override
        public void run () {
            System.out.println ("当前线程：" + Thread.currentThread ().getId ());
            int i = 10 / 2;
            System.out.println ("运行结果" + i);

        }
    }

    public static class Callable01 implements Callable<Integer> {
        @Override
        public Integer call () throws Exception {
            System.out.println ("当前线程：" + Thread.currentThread ().getId ());
            int i = 10 / 2;
            System.out.println ("运行结果" + i);

            return i;
        }
    }
}
