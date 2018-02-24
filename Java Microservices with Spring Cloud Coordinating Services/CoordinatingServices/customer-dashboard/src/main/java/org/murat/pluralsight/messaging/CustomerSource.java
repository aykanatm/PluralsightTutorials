package org.murat.pluralsight.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CustomerSource {
    @Output("channelOne")
    MessageChannel channelOne();
    @Output("channelTwo")
    MessageChannel channelTwo();
}
