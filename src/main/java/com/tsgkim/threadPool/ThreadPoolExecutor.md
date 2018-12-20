```
public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory,
                              RejectedExecutionHandler handler) {
        if (corePoolSize < 0 ||
            // maximumPoolSize 必须大于或等于1，大于或等于 corePoolSize
            maximumPoolSize <= 0 ||
            maximumPoolSize < corePoolSize ||
            keepAliveTime < 0)
            throw new IllegalArgumentException();
            // 通过 Executors 线程池静态工厂提供的默认实现对 workQueue，threadFactory，handler 实例化
        if (workQueue == null || threadFactory == null || handler == null)
            throw new NullPointerException();
        this.acc = System.getSecurityManager() == null ?
                null :
                AccessController.getContext();
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.workQueue = workQueue;
        this.keepAliveTime = unit.toNanos(keepAliveTime);
        this.threadFactory = threadFactory;
        this.handler = handler;
    }
``` 
*   **corePoolSize** 常驻核心线程数
    > 如果等于 0，则任务执行完之后，没有任何请求进入时销毁线程池的线程，如果大于 0，即使本地任务执行完毕，核心线程也不会被销毁。这个值的设置非常关键，设置过大会浪费资源，设置过小会导致线程频繁地创建或销毁。
    
*   **maximumPoolSize** 线程池能够容纳同时执行的最大线程数
    > 必须大于或等于 1，大于或等于 corePoolSize。如果请求的线程数大于此值，缓存在 BlockingQueue<Runnable> workQueue 队列中。如果 maximumPoolSize 与 corePoolSize 相等，即是固定大小线程池。
    
*   **keepAliveTime** 线程池中的线程空闲时间
    > 当空闲时间达到 keepAliveTime 值时，线程会被销毁，直到只剩下 corePoolSize 个线程为止，避免浪费内存和句柄资源。在默认情况下，当线程池的线程数大于 corePoolSize 时 keepAliveTime 才会起作用。但是当 ThreadPoolExecutor 的 allowCoreThreadTimeOut 变量设置为 true 时 ， 核心线程超时后也会被回收。
    
*   **TimeUnit** 时间单位
    > keepAliveTime 的时间单位通常是 TimeUnit.SECONDS 。
    
*   **workQueue** 缓存队列
    > 请求的线程数大于 maximumPoolSize 时，缓存在 BlockingQueue<Runnable> workQueue 队列中。可以使用的 LinkedBlockingQueue， 它是单向链表，使用锁来控制入队和出队的原子性，两个锁分别控制元素的添加和获取，是一个生产消费模型队列。
    
*   **threadFactory** 线程工厂
    > 它用来生产一组相同任务的结程。线程池的命名是通过给这个 factory 增加组名前缀来实现的。在虚拟机栈分析时，就可以知道线程任务是由哪个线程工厂产生的。
    
*   **handler** 执行拒绝策晤的对象
    > 当超过 BlockingQueue<Runnable> workQueue 的任务缓存区上限的时候，就可以通过该策略处理请求，这是种简单的限流保护。友好的拒绝策略可以是如下三种: 
    (1)保存到数据库进行削峰填谷 在空休时再提取出来执行。
    (2)转向某个提示页面。
    (3)打印日志。
    
*   阿里规范
    > 线程池不允许使用Executors去创建，而是通过ThreadPoolExecutor的方式，这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。Executors各个方法的弊端：  
    	  1. newFixedThreadPool和newSingleThreadExecutor:  	
    	   &emsp;&emsp;主要问题是堆积的请求处理队列可能会耗费非常大的内存，甚至OOM。  
    	  2. newCachedThreadPool和newScheduledThreadPool:  	
    	   &emsp;&emsp;主要问题是线程数最大数是Integer.MAX_VALUE，可能会创建数量非常多的线程，甚至OOM。