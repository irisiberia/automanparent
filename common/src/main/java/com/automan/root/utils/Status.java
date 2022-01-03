package com.automan.root.utils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author he.zhou
 * @Date 2021-12-29
 */
public class Status {
    public static final int ERROR = -1024;

    public static final int SUCCESS = 0;

    private static final long serialVersionUID = 7569524956130901222L;

    private final int status;

    private final String reason;

    @JsonCreator
    protected Status(@JsonProperty("status") int status, @JsonProperty("reason") String reason) {
        this.status = status;
        this.reason = reason;
    }

    public static Status create(int status, String reason) {
        return new Status(status, reason);
    }

    public static Status success() {
        return create(0, null);
    }

    public static Status error(String reason) {
        return create(-1024, reason);
    }

    public static Status error(int status, String reason) {
//        Assert.isTrue((status < 0), "status must be less than 0");
        return create(status, reason);
    }

    @JsonIgnore
    public boolean isSuccess() {
        return (this.status >= 0);
    }

    public int getStatus() {
        return this.status;
    }

    public String getReason() {
        return this.reason;
    }

//    public StatusCodeException asError() {
//        return new StatusCodeException(this);
//    }
//
//    public StatusCodeException asError(String message) {
//        return new StatusCodeException(message, this);
//    }
//
//    public StatusCodeException asError(String message, Throwable cause) {
//        return new StatusCodeException(message, cause, this);
//    }
//
//    public StatusCodeException asError(Throwable cause) {
//        return new StatusCodeException(cause, this);
//    }

    public int compareTo(Status o) {
        return this.status - o.status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Status)) {
            return false;
        }
        Status status1 = (Status)o;
        if (this.status != status1.status) {
            return false;
        }
        return (this.reason != null) ? this.reason.equals(status1.reason) : ((status1.reason == null));
    }

    @Override
    public int hashCode() {
        int result = this.status;
        result = 31 * result + ((this.reason != null) ? this.reason.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return (new StringBuilder(5))
                .append(this.status)
                .append(' ')
                .append(this.reason)
                .toString();
    }
}
