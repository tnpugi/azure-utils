package com.tnpugi.azureutils.eventhub;

import com.azure.messaging.eventhubs.models.EventPosition;
import com.azure.messaging.eventhubs.models.PartitionEvent;

public abstract class EventHubReceiveProcessor {
    public abstract void processEvent(String partitionId, PartitionEvent event);
    public abstract void storePosition(String partitionId, Long offset);
    public abstract EventPosition retrieveCurrentPosition(String partitionId);
}
