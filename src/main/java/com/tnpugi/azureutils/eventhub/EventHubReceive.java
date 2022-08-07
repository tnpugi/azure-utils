package com.tnpugi.azureutils.eventhub;

import com.azure.messaging.eventhubs.*;
import com.azure.messaging.eventhubs.models.*;


public class EventHubReceive {

    private final EventHubProps props;
    private final EventHubReceiveProcessor processor;

    public EventHubReceive(EventHubProps props, EventHubReceiveProcessor processor) {
        this.props = props;
        this.processor = processor;
    }

    public void receiveEvents() {
        EventHubConsumerAsyncClient consumer = new EventHubClientBuilder()
            .connectionString(this.props.getConnectionString(), this.props.getEventHubName())
            .consumerGroup(this.props.getConsumerGroup())
            .buildAsyncConsumerClient();

        for (int i =0; i < this.props.getNoOfPartitions(); i++) {
            final String partitionId = String.valueOf(i);
            final EventPosition currPosition = this.processor.retrieveCurrentPosition(partitionId);
            consumer.receiveFromPartition(partitionId, currPosition).subscribe(event -> {
                this.processor.processEvent(partitionId, event);
                this.processor.storePosition(partitionId, event.getData().getOffset());
            });
        }
    }
}
