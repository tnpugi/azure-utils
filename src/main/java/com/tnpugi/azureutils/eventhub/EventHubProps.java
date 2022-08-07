package com.tnpugi.azureutils.eventhub;

public class EventHubProps {
    private final String connectionString;
    private final String eventHubName;
    private final String consumerGroup;
    private final int noOfPartitions;

    public EventHubProps(String connectionString, String eventHubName, String consumerGroup, int noOfPartitions) {
        this.connectionString = connectionString;
        this.eventHubName = eventHubName;
        this.consumerGroup = consumerGroup;
        this.noOfPartitions = noOfPartitions;
    }

    public String getConnectionString() { return connectionString; }
    public String getEventHubName() { return eventHubName; }
    public String getConsumerGroup() { return consumerGroup; }
    public int getNoOfPartitions() { return noOfPartitions; }
}
