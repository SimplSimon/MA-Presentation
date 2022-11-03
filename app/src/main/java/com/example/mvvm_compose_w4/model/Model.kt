package com.example.mvvm_compose_w4

import com.google.gson.annotations.SerializedName

data class APIConvert(

	@field:SerializedName("MRData")
	val mRData: MRData? = null
)

data class DriverStandingsItem(

	@field:SerializedName("wins")
	val wins: String? = null,

	@field:SerializedName("positionText")
	val positionText: String? = null,

	@field:SerializedName("Driver")
	val driver: Driver? = null,

	@field:SerializedName("Constructors")
	val constructors: List<ConstructorsItem?>? = null,

	@field:SerializedName("position")
	val position: String? = null,

	@field:SerializedName("points")
	val points: String? = null
)

data class ConstructorsItem(

	@field:SerializedName("nationality")
	val nationality: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("constructorId")
	val constructorId: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class StandingsTable(

	@field:SerializedName("StandingsLists")
	val standingsLists: List<StandingsListsItem?>? = null,

	@field:SerializedName("season")
	val season: String? = null
)

data class Driver(

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("driverId")
	val driverId: String? = null,

	@field:SerializedName("permanentNumber")
	val permanentNumber: String? = null,

	@field:SerializedName("nationality")
	val nationality: String? = null,

	@field:SerializedName("givenName")
	val givenName: String? = null,

	@field:SerializedName("familyName")
	val familyName: String? = null,

	@field:SerializedName("dateOfBirth")
	val dateOfBirth: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class MRData(

	@field:SerializedName("xmlns")
	val xmlns: String? = null,

	@field:SerializedName("total")
	val total: String? = null,

	@field:SerializedName("offset")
	val offset: String? = null,

	@field:SerializedName("series")
	val series: String? = null,

	@field:SerializedName("limit")
	val limit: String? = null,

	@field:SerializedName("StandingsTable")
	val standingsTable: StandingsTable? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class StandingsListsItem(

	@field:SerializedName("round")
	val round: String? = null,

	@field:SerializedName("DriverStandings")
	val driverStandings: List<DriverStandingsItem?>? = null,

	@field:SerializedName("season")
	val season: String? = null
)

data class DriverMessage(
	val position: Int,
	val givenName: String,
	val familyName: String,
	val team: String,
	val points: Int
)