package com.lonelycountry.task;

import com.lonelycountry.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author YeFan
 * 2018/4/4.
 */
@Component
public class ScheduledTasks {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTasks.class);

    /**
     * 上一次开始执行时间点之后5秒再执行
     */
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        LOGGER.info("the time is now {}", DateUtil.format(LocalDateTime.now()));
    }

    /**
     * 上一次执行完毕时间点之后5秒再执行
     */
    @Scheduled(fixedDelay = 5000)
    public void reportCurrentTime1() {
        LOGGER.info("the time is now {}", DateUtil.format(LocalDateTime.now()));
    }

    /**
     * 上一次执行完毕时间点之后5秒再执行
     */
    @Scheduled(initialDelay = 1000, fixedDelay = 5000)
    public void reportCurrentTime2() {
        LOGGER.info("the time is now {}", DateUtil.format(LocalDateTime.now()));
    }

    /**
     * 从0秒开始，每三十秒执行一次
     */
    @Scheduled(cron="0/30 * * * * ?")
    public void reportCurrentTime3() {
        LOGGER.info("the time is now {}", DateUtil.format(LocalDateTime.now()));
    }

    /**
     * 从10秒开始，每三十秒执行一次
     */
    @Scheduled(cron="10/30 * * * * ?")
    public void reportCurrentTime4() {
        LOGGER.info("the time is now {}", DateUtil.format(LocalDateTime.now()));
    }

    /**
     *  从1日开始,每5天执行一次
     */
    @Scheduled(cron="* * * 1/5 * ? ")
    public void reportCurrentTime5() {
        LOGGER.info("the time is now {}", DateUtil.format(LocalDateTime.now()));
    }

}
