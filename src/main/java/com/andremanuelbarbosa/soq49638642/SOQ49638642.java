package com.andremanuelbarbosa.soq49638642;

import de.spinscale.dropwizard.jobs.JobsBundle;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class SOQ49638642 extends Application<SOQ49638642Configuration> {

    private Bootstrap<SOQ49638642Configuration> bootstrap;

    @Override
    public void initialize(Bootstrap<SOQ49638642Configuration> bootstrap) {

        super.initialize(bootstrap);

        this.bootstrap = bootstrap;
    }

    @Override
    public void run(SOQ49638642Configuration configuration, Environment environment) throws Exception {

        final DBI dbi = (new DBIFactory()).build(environment, configuration.getDataSourceFactory(), "kmd");

        final SOQ49638642Job soq49638642Job = new SOQ49638642Job(new SOQ49638642Service(dbi.onDemand(SOQ49638642Dao.class)));

        final JobsBundle jobsBundle = new JobsBundle(soq49638642Job);

        jobsBundle.run(configuration, environment);
    }

    public static void main(String[] args) throws Exception {

        new SOQ49638642().run(args);
    }
}
