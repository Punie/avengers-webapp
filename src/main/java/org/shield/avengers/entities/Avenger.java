package org.shield.avengers.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.*;

@Document(collection = "avengers")
public class Avenger
{
    @Id
    private String id;

    @NotNull
    @Indexed(unique = true)
    @Field("alias")
    private String alias;

    @NotNull
    @Field("first_name")
    private String firstName;

    @NotNull
    @Field("last_name")
    private String lastName;

    @NotNull
    @Min(0) @Max(10)
    @Field("power")
    private Integer power;

    @Field("image_url")
    private String imageURL;

    @NotNull
    @DBRef
    private Agent agent;


    public String getId ()
    {
        return id;
    }
    public void setId (String id)
    {
        this.id = id;
    }

    public String getAlias ()
    {
        return alias;
    }
    public void setAlias (String alias)
    {
        this.alias = alias;
    }

    public String getFirstName ()
    {
        return firstName;
    }
    public void setFirstName (String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName ()
    {
        return lastName;
    }
    public void setLastName (String lastName)
    {
        this.lastName = lastName;
    }

    public Integer getPower ()
    {
        return power;
    }
    public void setPower (Integer power)
    {
        this.power = power;
    }

    public String getImageURL ()
    {
        return imageURL;
    }
    public void setImageURL (String imageURL)
    {
        this.imageURL = imageURL;
    }

    public Agent getAgent ()
    {
        return agent;
    }
    public void setAgent (Agent agent)
    {
        this.agent = agent;
    }
}