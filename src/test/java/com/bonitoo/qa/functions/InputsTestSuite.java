package com.bonitoo.qa.functions;

import com.bonitoo.qa.SetupTestSuite;
import org.influxdata.client.QueryApi;
import org.influxdata.query.FluxTable;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputsTestSuite {

    private static final Logger LOG = LoggerFactory.getLogger(InputsTestSuite.class);
    private static QueryApi queryClient = SetupTestSuite.getInfluxDBClient().getQueryApi();


    @BeforeClass
    public static void setup(){

        SetupTestSuite.setupAirRecords();

    }


    @Test
    public void bucketsTest(){

        String query = String.format("buckets()");

        List<FluxTable> tables = queryClient.query(query, SetupTestSuite.getInflux2conf().getOrgId());

        //for fun and inspection
        SetupTestSuite.printTables(query, tables);

        assertThat(tables.size()).isEqualTo(1);

        assertThat(tables.get(0).getRecords().get(0).getValueByKey("name"))
                .isEqualTo(SetupTestSuite.getTestConf().getOrg().getBucket());
        assertThat(tables.get(0).getRecords().get(0).getValueByKey("id"))
                .isEqualTo(SetupTestSuite.getInflux2conf().getBucketIds().get(0));
        assertThat(tables.get(0).getRecords().get(0).getValueByKey("organizationID"))
                .isEqualTo(SetupTestSuite.getInflux2conf().getOrgId());



    }
}
