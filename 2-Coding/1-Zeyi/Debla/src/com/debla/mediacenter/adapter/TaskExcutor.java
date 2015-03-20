package com.debla.mediacenter.adapter;

import android.os.Process;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 异步任务执行器，耗时的数据加载和处理操作都在这里执行
 * @author Cocoonshu
 * @date   2014-11-07 15:07:56
 */
public class TaskExcutor {

	private static final int      KEEP_ALIVE_TIME    = 10;
	private static final int      CORE_POOL_SIZE     = 4;
	private static final int      MAX_POOL_SIZE      = 8;
	private static final String   TASK_EXECUTOR_NAME = "TaskExcutor";
	private        final Executor mExecutor;
	
	public TaskExcutor() {
        mExecutor = new ThreadPoolExecutor(
        		CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME,
                TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), 
                new PriorityThreadFactory(TASK_EXECUTOR_NAME, Process.THREAD_PRIORITY_BACKGROUND));
	}
	
	/**
	 * 提交异步任务到任务执行器
	 * @param job 异步任务
	 * @return
	 */
	public <T> Future<T> submit(Job<T> job) {
		return submit(job, null);
	}
	
	/**
	 * 提交异步任务到任务执行器，当任务执行完毕后，异步任务监听器会被回调
	 * @param job 异步任务
	 * @param listener 异步任务监听器
	 * @return
	 */
	public <T> Future<T> submit(Job<T> job, FutureListener<T> listener) {
		Worker<T> woker = new Worker<T>(job, listener);
        mExecutor.execute(woker);
        return woker;
	}

	/**
	 * 异步任务执行单元
	 * @author Cocoonshu
	 * @date   2014-11-07 17:33:14
	 */
	private class Worker<T> implements Runnable, Future<T>, JobContext {

		public Worker(Job<T> job, FutureListener<T> listener) {
            // TODO
        }
		
		@Override
		public void setCancelListener(CancelListener listener) {
			// TODO
		}

		@Override
		public void cancel() {
			// TODO
		}

		@Override
		public boolean isCancelled() {
			// TODO
			return false;
		}

		@Override
		public boolean isDone() {
			// TODO
			return false;
		}

		@Override
		public T get() {
			// TODO
			return null;
		}

		@Override
		public void waitDone() {
			// TODO
		}

		@Override
		public void run() {
			// TODO
		}
		
	}
	
	/**
	 * 任务引用
	 * @author Cocoonshu
	 * @date   2014-11-07 17:34:00
	 */
	public interface Future<T> {
		
		/**
		 * 取消任务
		 */
	    public void cancel();

	    /**
	     * 任务是否取消
	     * @return
	     */
	    public boolean isCancelled();

	    /**
	     * 任务是否完成
	     * @return
	     */
	    public boolean isDone();

	    /**
	     * 获取任务结果
	     * @return
	     */
	    public T get();

	    /**
	     * 同步等待任务结束，调用线程讲在此阻塞，直到任务执行结束
	     */
	    public void waitDone();
	}
	
	/**
	 * 任务结束监听
	 * @author Cocoonshu
	 * @date   2014-11-07 17:37:51
	 */
	public interface FutureListener<T> {
		
		/**
		 * 任务执行结束回调
		 * @param future 任务引用
		 */
	    public void onFutureDone(Future<T> future);
	}
	
	/**
	 * 任务取消监听
	 * @author Cocoonshu
	 * @date   2014-11-07 17:39:19
	 */
	public interface CancelListener {
		
		/**
		 * 任务取消回调
		 */
        public void onCancel();
    }
	
	/**
	 * 异步任务
	 * @author Cocoonshu
	 * @date   2014-11-07 17:39:54
	 */
	public interface Job<T> {
		
		/**
		 * 任务执行体
		 * @param jobContext 任务执行环境
		 * @return 任务执行结果
		 */
        public T run(JobContext jobContext);
    }

	/**
	 * 任务执行环境
	 * @author Cocoonshu
	 * @date   2014-11-07 17:42:25
	 */
    public interface JobContext {
    	
    	/**
    	 * 任务是否被取消，如果是，则需要处理任务执行流程和任务结果
    	 * @return
    	 */
        boolean isCancelled();

        /**
         * 设置取消任务监听
         * @param listener 取消任务监听
         */
        void setCancelListener(CancelListener listener);
    }

    /**
     * 任务执行环境预实现存根
     * 已防止JobContext没有被实现时，出现异常
     * @author Cocoonshu
     * @date   2014-11-07 17:43:39
     */
    private static class JobContextStub implements JobContext {
    	
        @Override
        public boolean isCancelled() {
        	// 空实现，无需处理，默认返回不取消任务
            return false;
        }

        @Override
        public void setCancelListener(CancelListener listener) {
        	// 空实现，无需处理
        }
        
    }

    /**
     * 线程生成工厂，用于生成所需线程
     * @author Cocoonshu
     * @date   2014-11-07 17:45:02
     */
    public class PriorityThreadFactory implements ThreadFactory {
        private final int           mPriority;
        private final AtomicInteger mNumber = new AtomicInteger();
        private final String        mName;

        public PriorityThreadFactory(String name, int priority) {
            mName = name;
            mPriority = priority;
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, mName + '-' + mNumber.getAndIncrement()) {
                @Override
                public void run() {
                    Process.setThreadPriority(mPriority);
                    super.run();
                }
            };
        }
    }
}
