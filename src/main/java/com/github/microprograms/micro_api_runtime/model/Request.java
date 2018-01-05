package com.github.microprograms.micro_api_runtime.model;

import com.github.microprograms.micro_nested_data_model_runtime.Comment;
import com.github.microprograms.micro_nested_data_model_runtime.Required;

public class Request {
    @Comment("API接口名字") @Required(true) private String apiName;
    @Comment("请求唯一标识符") @Required(false) private String uuid;
    @Comment("请求发送时间") @Required(false) private long sendToEngineTimestamp;
    @Comment("请求被服务器开始处理的时间戳") @Required(false) private long executeByEngineTimestamp;

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public long getSendToEngineTimestamp() {
        return sendToEngineTimestamp;
    }

    public void setSendToEngineTimestamp(long sendToEngineTimestamp) {
        this.sendToEngineTimestamp = sendToEngineTimestamp;
    }

    public long getExecuteByEngineTimestamp() {
        return executeByEngineTimestamp;
    }

    public void setExecuteByEngineTimestamp(long executeByEngineTimestamp) {
        this.executeByEngineTimestamp = executeByEngineTimestamp;
    }
}
