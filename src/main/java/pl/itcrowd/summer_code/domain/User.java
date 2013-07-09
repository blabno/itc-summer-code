package pl.itcrowd.summer_code.domain;

public class User {

    private String email;

    private Long id;

    public User()
    {
    }

    public User(Long id, String email)
    {
        this.id = id;
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }

        User user = (User) o;

        if (!(id != null ? !id.equals(user.id) : user.id != null)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode()
    {
        return id != null ? id.hashCode() : 0;
    }
}
