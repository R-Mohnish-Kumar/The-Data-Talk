package com.fastestindia.thedatatalk.ProfileActivities

class ProfileUpdate {
    var designation: String
    var company : String
    var experience : String
    var college : String
    var stream : String
    var profile_brief : String
    var first_name : String
    var last_name : String

    constructor(designation: String, company: String, experience: String, college: String, stream: String, profile_brief: String, first_name: String, last_name: String) {
        this.designation = designation
        this.company = company
        this.experience = experience
        this.college = college
        this.stream = stream
        this.profile_brief = profile_brief
        this.first_name = first_name
        this.last_name = last_name
    }
}