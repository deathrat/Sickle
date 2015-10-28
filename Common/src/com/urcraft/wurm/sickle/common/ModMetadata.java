package com.urcraft.wurm.sickle.common;

public class ModMetadata
{
    private String _modName;
    private String _modTag;
    private String _desc;
    private String _version;
    private String _url;
    private String[] _authors;

    public ModMetadata(String modName)
    {
        _modName = modName;
    }

    public void setAuthors(String[] authors)
    {
        this._authors = authors;
    }

    public void setURL(String URL)
    {
        this._url = URL;
    }

    public void setVersion(String version)
    {
        this._version = version;
    }

    public void setDesc(String desc)
    {
        this._desc = desc;
    }

    public void setTag(String tag)
    {
        this._modTag = tag;
    }

    public String getModName()
    {
        return _modName;
    }

    public String getModTag()
    {
        return _modTag;
    }

    public String getDesc()
    {
        return _desc;
    }

    public String getVersion()
    {
        return _version;
    }

    public String getUrl()
    {
        return _url;
    }

    public String[] getAuthors()
    {
        return _authors;
    }
}
