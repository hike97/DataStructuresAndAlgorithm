package thinkingInjava.others;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hike97 2month
 * @create 2020-06-01 10:16
 * @desc 测试
 **/
public class Year {
	public static void main (String[] args) {
//		LocalDate now = LocalDate.now ();
//		LocalDate now = LocalDate.of (2020, 5, 29);
//		LocalDate start = now.minusYears (1L);
//		System.out.println ("start----->");
//		while (true){
//			now= now.minusMonths (1L);
//			if (now.equals (start))break;
//			System.out.println ("今天: "+now+":"+"昨天: "+start);
//		}
//		System.out.println ("end----->");

		int i = 0;
		int b = 2;
		try {
			int result = method (i, b);
			System.out.println (result);
		} catch (Exception e) {

			ScheduledThreadPoolExecutor service = new ScheduledThreadPoolExecutor(1);
			/**
			 * new timeTaskForException() 要执行的任务线程
			 * 1000：延迟多长时间执行
			 * 2000: 每隔多少长时间执行一次
			 * TimeUnit.MILLISECONDS：时间单位
			 */
			AtomicInteger count = new AtomicInteger (1);
			service.scheduleAtFixedRate(()->{
					System.out.printf ("第%d次执行", count.intValue ());
					method(i,b);
					count.incrementAndGet ();
					if (count.intValue ()>5){
						System.out.println ("线程池关闭");
						service.shutdown ();
					}
			}, 0, 3000, TimeUnit.MILLISECONDS);
			e.printStackTrace ();
		}

	}
	static int method(int a ,int b){
		System.out.println ("方法被执行");
		return a/b;
	}
}
