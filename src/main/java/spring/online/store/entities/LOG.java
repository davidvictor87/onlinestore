package spring.online.store.entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LOG {
	
	private static final Logger log = LoggerFactory.getLogger(LOG.class);
	
	public static final Logger applicationLogger() {
		return log;
	}

}
