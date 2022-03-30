package az.parvin.hremployeeservice.exceptionApi;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SingleMessage<D extends Serializable> extends ApiMessage implements Serializable {

    static final long serialVersionUID = 6385896097877475150L;
    D item;
}
