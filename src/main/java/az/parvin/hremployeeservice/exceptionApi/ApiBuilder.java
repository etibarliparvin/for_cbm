package az.parvin.hremployeeservice.exceptionApi;

import az.parvin.hremployeeservice.myException.BaseException;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Collections;

public interface ApiBuilder {

    default String timestamp() {
        return LocalDateTime.now(ZoneId.of("UTC")).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    default ApiError generateApiError(BaseException ex) {
        ApiError apiError = new ApiError();
        apiError.setMessage(ex.getMsg());
        apiError.setCode(ex.getCode());
        apiError.setDescription(ex.getDescription());
        return apiError;
    }

    default ApiInfo generateApiInfo(BaseException ex) {
        ApiInfo apiInfo = new ApiInfo();
        apiInfo.setTimestamp(timestamp());
        apiInfo.setSuccess(false);
        apiInfo.setStatus(ApiConstant.STATUS_FAILED);
        apiInfo.setErrors(Collections.singletonList(generateApiError(ex)));
        return apiInfo;
    }

    default ApiInfo generateApiInfo() {
        ApiInfo apiInfo = new ApiInfo();
        apiInfo.setTimestamp(timestamp());
        apiInfo.setSuccess(true);
        apiInfo.setStatus(ApiConstant.STATUS_OK);
        return apiInfo;
    }

    default ApiMessage generateApiMessage(ApiInfo apiInfo) {
        ApiMessage apiMessage = new ApiMessage();
        apiMessage.setApiInfo(apiInfo);
        return apiMessage;
    }

    default <L extends Serializable> SingleMessage<L> generateSingleMessage(L data) {
        SingleMessage<L> singleMessage = new SingleMessage<>();
        singleMessage.setItem(data);
        singleMessage.setApiInfo(generateApiInfo());
        return singleMessage;
    }

    default <L extends Serializable> CollectionMessage<L> generateCollectionMessage(Collection<L> collection) {
        CollectionMessage<L> collectionMessage = new CollectionMessage<>();
        collectionMessage.setItems(collection);
        collectionMessage.setApiInfo(generateApiInfo());
        return collectionMessage;
    }
}
