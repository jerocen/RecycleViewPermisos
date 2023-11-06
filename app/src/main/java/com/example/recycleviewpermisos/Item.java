package com.example.recycleviewpermisos;

public class Item
{
    String permission_name;

    public Item(String permission_name)
    {
        this.permission_name = permission_name;
    }

    public String getPermissionName()
    {
        return permission_name;
    }

    public void setName(String permission_name) {
        this.permission_name = permission_name;
    }


}
