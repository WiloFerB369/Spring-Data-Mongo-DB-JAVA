package adaschool.userservice.document;

import adaschool.userservice.controller.dto.UserDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class User {

    @Id

    private String id;

    private String name;

    private String lastName;

    @Indexed( unique = true)
    private String email;

    private Date createdAt;

    public User() {
    }

    public User(UserDto userDto)
    {
        this.name = userDto.getName();
        this.lastName = userDto.getLastName();
        this.email = userDto.getEmail();
        this.createdAt = new Date();
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public void update(UserDto userDto)
    {
        if(!userDto.getName().isEmpty() || userDto.getName() != null){
            this.name = userDto.getName();
        }
        if(!userDto.getLastName().isEmpty() || userDto.getLastName() != null){
            this.name = userDto.getLastName();
        }
    }
}
