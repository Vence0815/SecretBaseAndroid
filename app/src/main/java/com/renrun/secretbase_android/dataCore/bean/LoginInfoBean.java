package com.renrun.secretbase_android.dataCore.bean;

import java.util.List;

/**
 * Created by vence on 2018/6/10 17:06
 * 邮箱 ：vence0815@foxmail.com
 */
public class LoginInfoBean extends BaseBean {

    /**
     * data : {"user":{"id":"014fd8eac06a4c9d919dae152e97d062","phone":"17314904606","nickName":"星巴克","password":null,"gender":1,"birthYear":1997,"birthMonth":6,"birthDay":3,"personalitySignature":null,"constellation":null,"hometown":null,"location":"179","lastCoterie":"1001","headPicUrl":"head/1528001464290.jpg","backgroundPicUrl":null,"vipEndTime":null,"salt":"edf836d1c72de5e0488fa470ef30386b","bindCode":null,"token":"1528623442559","age":null,"fansNum":0,"concernNum":3,"thumbNum":2,"visitNum":9,"concern":null,"upgrade":0,"userCoteries":[{"userId":null,"coterieId":"1001","coterieProperty":null,"coterieYear":null,"haveExperience":null,"friendPurpose":null,"propertyValue":null,"yearValue":null,"experienceValue":null,"purposeValue":null}],"photos":[]},"token":"1528623442559"}
     */

    private DataEntity data;

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public static class DataEntity {
        /**
         * user : {"id":"014fd8eac06a4c9d919dae152e97d062","phone":"17314904606","nickName":"星巴克","password":null,"gender":1,"birthYear":1997,"birthMonth":6,"birthDay":3,"personalitySignature":null,"constellation":null,"hometown":null,"location":"179","lastCoterie":"1001","headPicUrl":"head/1528001464290.jpg","backgroundPicUrl":null,"vipEndTime":null,"salt":"edf836d1c72de5e0488fa470ef30386b","bindCode":null,"token":"1528623442559","age":null,"fansNum":0,"concernNum":3,"thumbNum":2,"visitNum":9,"concern":null,"upgrade":0,"userCoteries":[{"userId":null,"coterieId":"1001","coterieProperty":null,"coterieYear":null,"haveExperience":null,"friendPurpose":null,"propertyValue":null,"yearValue":null,"experienceValue":null,"purposeValue":null}],"photos":[]}
         * token : 1528623442559
         */

        private UserEntity user;
        private String token;

        public UserEntity getUser() {
            return user;
        }

        public void setUser(UserEntity user) {
            this.user = user;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public static class UserEntity {
            /**
             * id : 014fd8eac06a4c9d919dae152e97d062
             * phone : 17314904606
             * nickName : 星巴克
             * password : null
             * gender : 1
             * birthYear : 1997
             * birthMonth : 6
             * birthDay : 3
             * personalitySignature : null
             * constellation : null
             * hometown : null
             * location : 179
             * lastCoterie : 1001
             * headPicUrl : head/1528001464290.jpg
             * backgroundPicUrl : null
             * vipEndTime : null
             * salt : edf836d1c72de5e0488fa470ef30386b
             * bindCode : null
             * token : 1528623442559
             * age : null
             * fansNum : 0
             * concernNum : 3
             * thumbNum : 2
             * visitNum : 9
             * concern : null
             * upgrade : 0
             * userCoteries : [{"userId":null,"coterieId":"1001","coterieProperty":null,"coterieYear":null,"haveExperience":null,"friendPurpose":null,"propertyValue":null,"yearValue":null,"experienceValue":null,"purposeValue":null}]
             * photos : []
             */

            private String id;
            private String phone;
            private String nickName;
            private Object password;
            private int gender;
            private int birthYear;
            private int birthMonth;
            private int birthDay;
            private Object personalitySignature;
            private Object constellation;
            private Object hometown;
            private String location;
            private String lastCoterie;
            private String headPicUrl;
            private Object backgroundPicUrl;
            private Object vipEndTime;
            private String salt;
            private Object bindCode;
            private String token;
            private Object age;
            private int fansNum;
            private int concernNum;
            private int thumbNum;
            private int visitNum;
            private Object concern;
            private int upgrade;
            private List<UserCoteriesEntity> userCoteries;
            private List<?> photos;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public Object getPassword() {
                return password;
            }

            public void setPassword(Object password) {
                this.password = password;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public int getBirthYear() {
                return birthYear;
            }

            public void setBirthYear(int birthYear) {
                this.birthYear = birthYear;
            }

            public int getBirthMonth() {
                return birthMonth;
            }

            public void setBirthMonth(int birthMonth) {
                this.birthMonth = birthMonth;
            }

            public int getBirthDay() {
                return birthDay;
            }

            public void setBirthDay(int birthDay) {
                this.birthDay = birthDay;
            }

            public Object getPersonalitySignature() {
                return personalitySignature;
            }

            public void setPersonalitySignature(Object personalitySignature) {
                this.personalitySignature = personalitySignature;
            }

            public Object getConstellation() {
                return constellation;
            }

            public void setConstellation(Object constellation) {
                this.constellation = constellation;
            }

            public Object getHometown() {
                return hometown;
            }

            public void setHometown(Object hometown) {
                this.hometown = hometown;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getLastCoterie() {
                return lastCoterie;
            }

            public void setLastCoterie(String lastCoterie) {
                this.lastCoterie = lastCoterie;
            }

            public String getHeadPicUrl() {
                return headPicUrl;
            }

            public void setHeadPicUrl(String headPicUrl) {
                this.headPicUrl = headPicUrl;
            }

            public Object getBackgroundPicUrl() {
                return backgroundPicUrl;
            }

            public void setBackgroundPicUrl(Object backgroundPicUrl) {
                this.backgroundPicUrl = backgroundPicUrl;
            }

            public Object getVipEndTime() {
                return vipEndTime;
            }

            public void setVipEndTime(Object vipEndTime) {
                this.vipEndTime = vipEndTime;
            }

            public String getSalt() {
                return salt;
            }

            public void setSalt(String salt) {
                this.salt = salt;
            }

            public Object getBindCode() {
                return bindCode;
            }

            public void setBindCode(Object bindCode) {
                this.bindCode = bindCode;
            }

            public String getToken() {
                return token;
            }

            public void setToken(String token) {
                this.token = token;
            }

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public int getFansNum() {
                return fansNum;
            }

            public void setFansNum(int fansNum) {
                this.fansNum = fansNum;
            }

            public int getConcernNum() {
                return concernNum;
            }

            public void setConcernNum(int concernNum) {
                this.concernNum = concernNum;
            }

            public int getThumbNum() {
                return thumbNum;
            }

            public void setThumbNum(int thumbNum) {
                this.thumbNum = thumbNum;
            }

            public int getVisitNum() {
                return visitNum;
            }

            public void setVisitNum(int visitNum) {
                this.visitNum = visitNum;
            }

            public Object getConcern() {
                return concern;
            }

            public void setConcern(Object concern) {
                this.concern = concern;
            }

            public int getUpgrade() {
                return upgrade;
            }

            public void setUpgrade(int upgrade) {
                this.upgrade = upgrade;
            }

            public List<UserCoteriesEntity> getUserCoteries() {
                return userCoteries;
            }

            public void setUserCoteries(List<UserCoteriesEntity> userCoteries) {
                this.userCoteries = userCoteries;
            }

            public List<?> getPhotos() {
                return photos;
            }

            public void setPhotos(List<?> photos) {
                this.photos = photos;
            }

            public static class UserCoteriesEntity {
                /**
                 * userId : null
                 * coterieId : 1001
                 * coterieProperty : null
                 * coterieYear : null
                 * haveExperience : null
                 * friendPurpose : null
                 * propertyValue : null
                 * yearValue : null
                 * experienceValue : null
                 * purposeValue : null
                 */

                private Object userId;
                private String coterieId;
                private Object coterieProperty;
                private Object coterieYear;
                private Object haveExperience;
                private Object friendPurpose;
                private Object propertyValue;
                private Object yearValue;
                private Object experienceValue;
                private Object purposeValue;

                public Object getUserId() {
                    return userId;
                }

                public void setUserId(Object userId) {
                    this.userId = userId;
                }

                public String getCoterieId() {
                    return coterieId;
                }

                public void setCoterieId(String coterieId) {
                    this.coterieId = coterieId;
                }

                public Object getCoterieProperty() {
                    return coterieProperty;
                }

                public void setCoterieProperty(Object coterieProperty) {
                    this.coterieProperty = coterieProperty;
                }

                public Object getCoterieYear() {
                    return coterieYear;
                }

                public void setCoterieYear(Object coterieYear) {
                    this.coterieYear = coterieYear;
                }

                public Object getHaveExperience() {
                    return haveExperience;
                }

                public void setHaveExperience(Object haveExperience) {
                    this.haveExperience = haveExperience;
                }

                public Object getFriendPurpose() {
                    return friendPurpose;
                }

                public void setFriendPurpose(Object friendPurpose) {
                    this.friendPurpose = friendPurpose;
                }

                public Object getPropertyValue() {
                    return propertyValue;
                }

                public void setPropertyValue(Object propertyValue) {
                    this.propertyValue = propertyValue;
                }

                public Object getYearValue() {
                    return yearValue;
                }

                public void setYearValue(Object yearValue) {
                    this.yearValue = yearValue;
                }

                public Object getExperienceValue() {
                    return experienceValue;
                }

                public void setExperienceValue(Object experienceValue) {
                    this.experienceValue = experienceValue;
                }

                public Object getPurposeValue() {
                    return purposeValue;
                }

                public void setPurposeValue(Object purposeValue) {
                    this.purposeValue = purposeValue;
                }
            }
        }
    }
}
