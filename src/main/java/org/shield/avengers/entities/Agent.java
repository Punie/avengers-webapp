package org.shield.avengers.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.*;

@Document(collection = "agents")
public class Agent
{
    @Id
    private String id;

    @NotNull
    @Field("first_name")
    private String firstName;

    @NotNull
    @Field("last_name")
    private String lastName;

    @Field("image_url")
    private String imageURL;

    public String getId ()
    {
        return id;
    }
    public void setId (String id)
    {
        this.id = id;
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

    public String getImageURL ()
    {
        return imageURL;
    }
    public void setImageURL (String imageURL)
    {
        this.imageURL = imageURL;
    }
}