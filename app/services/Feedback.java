package services;

import java.util.*;

/**
 * Created by dinever on 4/5/16.
 */
public class Feedback {

    private Integer type;
    private Date createdAt;

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return this.type;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
