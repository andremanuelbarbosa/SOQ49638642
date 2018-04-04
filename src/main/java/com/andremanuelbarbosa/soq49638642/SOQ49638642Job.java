package com.andremanuelbarbosa.soq49638642;

import de.spinscale.dropwizard.jobs.Job;
import de.spinscale.dropwizard.jobs.annotations.Every;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Every("1min")
public class SOQ49638642Job extends Job {

    private static final Logger LOGGER = LoggerFactory.getLogger(SOQ49638642Job.class);

    private final SOQ49638642Service soq49638642Service;

    public SOQ49638642Job(SOQ49638642Service soq49638642Service) {

        this.soq49638642Service = soq49638642Service;
    }

    @Override
    public void doJob(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        LOGGER.info("SOQ49638642Job is running...");
    }
}
