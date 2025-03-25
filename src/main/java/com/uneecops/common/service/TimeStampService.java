package com.uneecops.common.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uneecops.common.entity.TimeCount;
import com.uneecops.common.repository.TimeStampRepo;

import jakarta.transaction.Transactional;

@Service
public class TimeStampService {

    private static final Logger logger = LoggerFactory.getLogger(TimeStampService.class);
    
    @Autowired
    TimeStampRepo repo;

    @Transactional
    public TimeCount saveTimestamp(String endTm) {
        try {
            logger.info("Processing timestamp for end time: {}", endTm);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:HH:mm");
            Date endDate = sdf.parse(endTm);

            // Calculate new timestamps
            String startTm = endTm;
            String newEndTm = sdf.format(new Date(endDate.getTime() + TimeUnit.HOURS.toMillis(1)));

            // Save to timestamp table
            TimeCount timeCount = new TimeCount();
            timeCount.setStartTm(startTm);
            timeCount.setEndTm(newEndTm);
            TimeCount savedTimeCount = repo.save(timeCount); 

            logger.info("Timestamp saved successfully: StartTm = {}, EndTm = {}", startTm, newEndTm);
            return savedTimeCount;
        } catch (ParseException e) {
            logger.error("Error during saving timestamp: {}", e.getMessage(), e);
            throw new RuntimeException("Error during saving timestamp: " + e.getMessage(), e);
        }
    }
}
