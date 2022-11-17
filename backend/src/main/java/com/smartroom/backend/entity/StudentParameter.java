package com.smartroom.backend.entity;

public class StudentParameter {

    private String school;

    private String sex;

    private Integer age;

    private String address;

    private String familySize;

    private String parentStatus;

    private String motherEducation;

    private String fatherEducation;

    private String motherJob;

    private String fatherJob;

    private String reasonToChooseThisSchool;

    private String guardian;

    private Long travelTime; // in minutes

    private Long pastClassFailures;

    private boolean extraEducationalSupport;

    private boolean extraPaidClasses;

    private boolean isInExtraCurricularActivities;

    private boolean isAttendedNurserySchool;

    private boolean willDoHigherEducation;

    private boolean isInternetAvailableInHome;

    private boolean isInRomanticRelationship;

    private Integer qualityOfFamilyRelationship; // 1 to 5 validation

    private Integer freeTimeAfterSchool; // 1 to 5

    private Integer timeSpendWithFriends; // 1 to 5

    private Integer dailyAlcoholConsumption; // 1 to 5

    private Integer weeklyAlcoholConsumption; // 1 to 5

    private Integer healthStatus; // 1 to 5

    private Long numberOfSchoolAbsences; // 1 to 5

    public StudentParameter() {
    }

    public StudentParameter(String school, String sex, Integer age, String address, String familySize, String parentStatus, String motherEducation, String fatherEducation, String motherJob, String fatherJob, String reasonToChooseThisSchool, String guardian, Long travelTime, Long pastClassFailures, boolean extraEducationalSupport, boolean extraPaidClasses, boolean isInExtraCurricularActivities, boolean isAttendedNurserySchool, boolean willDoHigherEducation, boolean isInternetAvailableInHome, boolean isInRomanticRelationship, Integer qualityOfFamilyRelationship, Integer freeTimeAfterSchool, Integer timeSpendWithFriends, Integer dailyAlcoholConsumption, Integer weeklyAlcoholConsumption, Integer healthStatus, Long numberOfSchoolAbsences) {
        this.school = school;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.familySize = familySize;
        this.parentStatus = parentStatus;
        this.motherEducation = motherEducation;
        this.fatherEducation = fatherEducation;
        this.motherJob = motherJob;
        this.fatherJob = fatherJob;
        this.reasonToChooseThisSchool = reasonToChooseThisSchool;
        this.guardian = guardian;
        this.travelTime = travelTime;
        this.pastClassFailures = pastClassFailures;
        this.extraEducationalSupport = extraEducationalSupport;
        this.extraPaidClasses = extraPaidClasses;
        this.isInExtraCurricularActivities = isInExtraCurricularActivities;
        this.isAttendedNurserySchool = isAttendedNurserySchool;
        this.willDoHigherEducation = willDoHigherEducation;
        this.isInternetAvailableInHome = isInternetAvailableInHome;
        this.isInRomanticRelationship = isInRomanticRelationship;
        this.qualityOfFamilyRelationship = qualityOfFamilyRelationship;
        this.freeTimeAfterSchool = freeTimeAfterSchool;
        this.timeSpendWithFriends = timeSpendWithFriends;
        this.dailyAlcoholConsumption = dailyAlcoholConsumption;
        this.weeklyAlcoholConsumption = weeklyAlcoholConsumption;
        this.healthStatus = healthStatus;
        this.numberOfSchoolAbsences = numberOfSchoolAbsences;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFamilySize() {
        return familySize;
    }

    public void setFamilySize(String familySize) {
        this.familySize = familySize;
    }

    public String getParentStatus() {
        return parentStatus;
    }

    public void setParentStatus(String parentStatus) {
        this.parentStatus = parentStatus;
    }

    public String getMotherEducation() {
        return motherEducation;
    }

    public void setMotherEducation(String motherEducation) {
        this.motherEducation = motherEducation;
    }

    public String getFatherEducation() {
        return fatherEducation;
    }

    public void setFatherEducation(String fatherEducation) {
        this.fatherEducation = fatherEducation;
    }

    public String getMotherJob() {
        return motherJob;
    }

    public void setMotherJob(String motherJob) {
        this.motherJob = motherJob;
    }

    public String getFatherJob() {
        return fatherJob;
    }

    public void setFatherJob(String fatherJob) {
        this.fatherJob = fatherJob;
    }

    public String getReasonToChooseThisSchool() {
        return reasonToChooseThisSchool;
    }

    public void setReasonToChooseThisSchool(String reasonToChooseThisSchool) {
        this.reasonToChooseThisSchool = reasonToChooseThisSchool;
    }

    public String getGuardian() {
        return guardian;
    }

    public void setGuardian(String guardian) {
        this.guardian = guardian;
    }

    public Long getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(Long travelTime) {
        this.travelTime = travelTime;
    }

    public Long getPastClassFailures() {
        return pastClassFailures;
    }

    public void setPastClassFailures(Long pastClassFailures) {
        this.pastClassFailures = pastClassFailures;
    }

    public boolean isExtraEducationalSupport() {
        return extraEducationalSupport;
    }

    public void setExtraEducationalSupport(boolean extraEducationalSupport) {
        this.extraEducationalSupport = extraEducationalSupport;
    }

    public boolean isExtraPaidClasses() {
        return extraPaidClasses;
    }

    public void setExtraPaidClasses(boolean extraPaidClasses) {
        this.extraPaidClasses = extraPaidClasses;
    }

    public boolean isInExtraCurricularActivities() {
        return isInExtraCurricularActivities;
    }

    public void setInExtraCurricularActivities(boolean inExtraCurricularActivities) {
        isInExtraCurricularActivities = inExtraCurricularActivities;
    }

    public boolean isAttendedNurserySchool() {
        return isAttendedNurserySchool;
    }

    public void setAttendedNurserySchool(boolean attendedNurserySchool) {
        isAttendedNurserySchool = attendedNurserySchool;
    }

    public boolean isWillDoHigherEducation() {
        return willDoHigherEducation;
    }

    public void setWillDoHigherEducation(boolean willDoHigherEducation) {
        this.willDoHigherEducation = willDoHigherEducation;
    }

    public boolean isInternetAvailableInHome() {
        return isInternetAvailableInHome;
    }

    public void setInternetAvailableInHome(boolean internetAvailableInHome) {
        isInternetAvailableInHome = internetAvailableInHome;
    }

    public boolean isInRomanticRelationship() {
        return isInRomanticRelationship;
    }

    public void setInRomanticRelationship(boolean inRomanticRelationship) {
        isInRomanticRelationship = inRomanticRelationship;
    }

    public Integer getQualityOfFamilyRelationship() {
        return qualityOfFamilyRelationship;
    }

    public void setQualityOfFamilyRelationship(Integer qualityOfFamilyRelationship) {
        this.qualityOfFamilyRelationship = qualityOfFamilyRelationship;
    }

    public Integer getFreeTimeAfterSchool() {
        return freeTimeAfterSchool;
    }

    public void setFreeTimeAfterSchool(Integer freeTimeAfterSchool) {
        this.freeTimeAfterSchool = freeTimeAfterSchool;
    }

    public Integer getTimeSpendWithFriends() {
        return timeSpendWithFriends;
    }

    public void setTimeSpendWithFriends(Integer timeSpendWithFriends) {
        this.timeSpendWithFriends = timeSpendWithFriends;
    }

    public Integer getDailyAlcoholConsumption() {
        return dailyAlcoholConsumption;
    }

    public void setDailyAlcoholConsumption(Integer dailyAlcoholConsumption) {
        this.dailyAlcoholConsumption = dailyAlcoholConsumption;
    }

    public Integer getWeeklyAlcoholConsumption() {
        return weeklyAlcoholConsumption;
    }

    public void setWeeklyAlcoholConsumption(Integer weeklyAlcoholConsumption) {
        this.weeklyAlcoholConsumption = weeklyAlcoholConsumption;
    }

    public Integer getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(Integer healthStatus) {
        this.healthStatus = healthStatus;
    }

    public Long getNumberOfSchoolAbsences() {
        return numberOfSchoolAbsences;
    }

    public void setNumberOfSchoolAbsences(Long numberOfSchoolAbsences) {
        this.numberOfSchoolAbsences = numberOfSchoolAbsences;
    }

    @Override
    public String toString() {
        return "StudentParameter{" +
                "school='" + school + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", familySize='" + familySize + '\'' +
                ", parentStatus='" + parentStatus + '\'' +
                ", motherEducation='" + motherEducation + '\'' +
                ", fatherEducation='" + fatherEducation + '\'' +
                ", motherJob='" + motherJob + '\'' +
                ", fatherJob='" + fatherJob + '\'' +
                ", reasonToChooseThisSchool='" + reasonToChooseThisSchool + '\'' +
                ", guardian='" + guardian + '\'' +
                ", travelTime=" + travelTime +
                ", pastClassFailures=" + pastClassFailures +
                ", extraEducationalSupport=" + extraEducationalSupport +
                ", extraPaidClasses=" + extraPaidClasses +
                ", isInExtraCurricularActivities=" + isInExtraCurricularActivities +
                ", isAttendedNurserySchool=" + isAttendedNurserySchool +
                ", willDoHigherEducation=" + willDoHigherEducation +
                ", isInternetAvailableInHome=" + isInternetAvailableInHome +
                ", isInRomanticRelationship=" + isInRomanticRelationship +
                ", qualityOfFamilyRelationship=" + qualityOfFamilyRelationship +
                ", freeTimeAfterSchool=" + freeTimeAfterSchool +
                ", timeSpendWithFriends=" + timeSpendWithFriends +
                ", dailyAlcoholConsumption=" + dailyAlcoholConsumption +
                ", weeklyAlcoholConsumption=" + weeklyAlcoholConsumption +
                ", healthStatus=" + healthStatus +
                ", numberOfSchoolAbsences=" + numberOfSchoolAbsences +
                '}';
    }
}
