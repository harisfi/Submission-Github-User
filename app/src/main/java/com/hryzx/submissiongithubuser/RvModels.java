package com.hryzx.submissiongithubuser;

import android.os.Parcel;
import android.os.Parcelable;

public class RvModels implements Parcelable {
    private String username, name, location, company;
    private int repository, followers, following, avatar;

    public RvModels() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getRepository() {
        return repository;
    }

    public void setRepository(int repository) {
        this.repository = repository;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    protected RvModels(Parcel in) {
        username = in.readString();
        name = in.readString();
        location = in.readString();
        company = in.readString();
        repository = in.readInt();
        followers = in.readInt();
        following = in.readInt();
        avatar = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(name);
        dest.writeString(location);
        dest.writeString(company);
        dest.writeInt(repository);
        dest.writeInt(followers);
        dest.writeInt(following);
        dest.writeInt(avatar);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<RvModels> CREATOR = new Creator<RvModels>() {
        @Override
        public RvModels createFromParcel(Parcel in) {
            return new RvModels(in);
        }

        @Override
        public RvModels[] newArray(int size) {
            return new RvModels[size];
        }
    };
}
