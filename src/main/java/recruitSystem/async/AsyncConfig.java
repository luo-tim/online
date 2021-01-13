package recruitSystem.async;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

import net.sf.json.JSON;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

	private final Logger logger = LoggerFactory.getLogger("AsyncConfig.class");

	@Override
	public Executor getAsyncExecutor() {
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		return executorService;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		// TODO Auto-generated method stub
		return new AsyncUncaughtExceptionHandler() {
			@Override
			public void handleUncaughtException(Throwable ex, Method method, Object... params) {
				// TODO Auto-generated method stub
				logger.error("async execute error, method:{}, param:{}", method.getName(), ex);
			}
		};
		// return null;
	}

}
