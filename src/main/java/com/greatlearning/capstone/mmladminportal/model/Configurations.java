package com.greatlearning.capstone.mmladminportal.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "configurations")
@EntityListeners(Configurations.class)
public class Configurations {

	@Id
	private String id;

	private String cognitoRegion = "";

	private String cognitoUserPoolId = "";
	private String cognitoUserPoolClientId = "";

	private String cognitoIdentityPoolId = "";

	private String cognitoCloudfrontHlsdomain = "";

	private String cognitoCloudfrontClassfieddomain = "";

	private String cognitoS3ApiVersion = "";
	private String cognitoS3BucketCourseDestination = "";
	private String cognitoS3BucketCourseHlsSourceOrigin = "";
	private String cognitoS3DestinationDomain = "";
	private String cognitoS3BucketCourseHlsDestinationOrigin = "";

	private String cognitoDynamoDbContentTbl = "";

	private String cognitoDynamoDbTagTbl = "";
	private String cognitoDynamoDbMmlWorkspace = "";
	private String cognitoDynamoDbOrgAccounts = "";
	private String cognitoDynamoDbUserAccounts = "";
	private String cognitoDynamoDbUserSubscription = "";
	private String cognitoDynamoDbUserWallet = "";
	private String cognitoDynamoDbUserBilling = "";
	private String cognitoDynamoDbUserCredit = "";

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCognitoRegion() {
		return cognitoRegion;
	}

	public void setCognitoRegion(String cognitoRegion) {
		this.cognitoRegion = cognitoRegion;
	}

	public String getCognitoUserPoolId() {
		return cognitoUserPoolId;
	}

	public void setCognitoUserPoolId(String cognitoUserPoolId) {
		this.cognitoUserPoolId = cognitoUserPoolId;
	}

	public String getCognitoUserPoolClientId() {
		return cognitoUserPoolClientId;
	}

	public void setCognitoUserPoolClientId(String cognitoUserPoolClientId) {
		this.cognitoUserPoolClientId = cognitoUserPoolClientId;
	}

	public String getCognitoIdentityPoolId() {
		return cognitoIdentityPoolId;
	}

	public void setCognitoIdentityPoolId(String cognitoIdentityPoolId) {
		this.cognitoIdentityPoolId = cognitoIdentityPoolId;
	}

	public String getCognitoCloudfrontHlsdomain() {
		return cognitoCloudfrontHlsdomain;
	}

	public void setCognitoCloudfrontHlsdomain(String cognitoCloudfrontHlsdomain) {
		this.cognitoCloudfrontHlsdomain = cognitoCloudfrontHlsdomain;
	}

	public String getCognitoCloudfrontClassfieddomain() {
		return cognitoCloudfrontClassfieddomain;
	}

	public void setCognitoCloudfrontClassfieddomain(String cognitoCloudfrontClassfieddomain) {
		this.cognitoCloudfrontClassfieddomain = cognitoCloudfrontClassfieddomain;
	}

	public String getCognitoS3ApiVersion() {
		return cognitoS3ApiVersion;
	}

	public void setCognitoS3ApiVersion(String cognitoS3ApiVersion) {
		this.cognitoS3ApiVersion = cognitoS3ApiVersion;
	}

	public String getCognitoS3BucketCourseDestination() {
		return cognitoS3BucketCourseDestination;
	}

	public void setCognitoS3BucketCourseDestination(String cognitoS3BucketCourseDestination) {
		this.cognitoS3BucketCourseDestination = cognitoS3BucketCourseDestination;
	}

	public String getCognitoS3BucketCourseHlsSourceOrigin() {
		return cognitoS3BucketCourseHlsSourceOrigin;
	}

	public void setCognitoS3BucketCourseHlsSourceOrigin(String cognitoS3BucketCourseHlsSourceOrigin) {
		this.cognitoS3BucketCourseHlsSourceOrigin = cognitoS3BucketCourseHlsSourceOrigin;
	}

	public String getCognitoS3DestinationDomain() {
		return cognitoS3DestinationDomain;
	}

	public void setCognitoS3DestinationDomain(String cognitoS3DestinationDomain) {
		this.cognitoS3DestinationDomain = cognitoS3DestinationDomain;
	}

	public String getCognitoS3BucketCourseHlsDestinationOrigin() {
		return cognitoS3BucketCourseHlsDestinationOrigin;
	}

	public void setCognitoS3BucketCourseHlsDestinationOrigin(String cognitoS3BucketCourseHlsDestinationOrigin) {
		this.cognitoS3BucketCourseHlsDestinationOrigin = cognitoS3BucketCourseHlsDestinationOrigin;
	}

	public String getCognitoDynamoDbContentTbl() {
		return cognitoDynamoDbContentTbl;
	}

	public void setCognitoDynamoDbContentTbl(String cognitoDynamoDbContentTbl) {
		this.cognitoDynamoDbContentTbl = cognitoDynamoDbContentTbl;
	}

	public String getCognitoDynamoDbTagTbl() {
		return cognitoDynamoDbTagTbl;
	}

	public void setCognitoDynamoDbTagTbl(String cognitoDynamoDbTagTbl) {
		this.cognitoDynamoDbTagTbl = cognitoDynamoDbTagTbl;
	}

	public String getCognitoDynamoDbMmlWorkspace() {
		return cognitoDynamoDbMmlWorkspace;
	}

	public void setCognitoDynamoDbMmlWorkspace(String cognitoDynamoDbMmlWorkspace) {
		this.cognitoDynamoDbMmlWorkspace = cognitoDynamoDbMmlWorkspace;
	}

	public String getCognitoDynamoDbOrgAccounts() {
		return cognitoDynamoDbOrgAccounts;
	}

	public void setCognitoDynamoDbOrgAccounts(String cognitoDynamoDbOrgAccounts) {
		this.cognitoDynamoDbOrgAccounts = cognitoDynamoDbOrgAccounts;
	}

	public String getCognitoDynamoDbUserAccounts() {
		return cognitoDynamoDbUserAccounts;
	}

	public void setCognitoDynamoDbUserAccounts(String cognitoDynamoDbUserAccounts) {
		this.cognitoDynamoDbUserAccounts = cognitoDynamoDbUserAccounts;
	}

	public String getCognitoDynamoDbUserSubscription() {
		return cognitoDynamoDbUserSubscription;
	}

	public void setCognitoDynamoDbUserSubscription(String cognitoDynamoDbUserSubscription) {
		this.cognitoDynamoDbUserSubscription = cognitoDynamoDbUserSubscription;
	}

	public String getCognitoDynamoDbUserWallet() {
		return cognitoDynamoDbUserWallet;
	}

	public void setCognitoDynamoDbUserWallet(String cognitoDynamoDbUserWallet) {
		this.cognitoDynamoDbUserWallet = cognitoDynamoDbUserWallet;
	}

	public String getCognitoDynamoDbUserBilling() {
		return cognitoDynamoDbUserBilling;
	}

	public void setCognitoDynamoDbUserBilling(String cognitoDynamoDbUserBilling) {
		this.cognitoDynamoDbUserBilling = cognitoDynamoDbUserBilling;
	}

	public String getCognitoDynamoDbUserCredit() {
		return cognitoDynamoDbUserCredit;
	}

	public void setCognitoDynamoDbUserCredit(String cognitoDynamoDbUserCredit) {
		this.cognitoDynamoDbUserCredit = cognitoDynamoDbUserCredit;
	}

	@Override
	public String toString() {
		return "Configurations [id=" + id + ", cognitoRegion=" + cognitoRegion + ", cognitoUserPoolId="
				+ cognitoUserPoolId + ", cognitoUserPoolClientId=" + cognitoUserPoolClientId
				+ ", cognitoIdentityPoolId=" + cognitoIdentityPoolId + ", cognitoCloudfrontHlsdomain="
				+ cognitoCloudfrontHlsdomain + ", cognitoCloudfrontClassfieddomain=" + cognitoCloudfrontClassfieddomain
				+ ", cognitoS3ApiVersion=" + cognitoS3ApiVersion + ", cognitoS3BucketCourseDestination="
				+ cognitoS3BucketCourseDestination + ", cognitoS3BucketCourseHlsSourceOrigin="
				+ cognitoS3BucketCourseHlsSourceOrigin + ", cognitoS3DestinationDomain=" + cognitoS3DestinationDomain
				+ ", cognitoS3BucketCourseHlsDestinationOrigin=" + cognitoS3BucketCourseHlsDestinationOrigin
				+ ", cognitoDynamoDbContentTbl=" + cognitoDynamoDbContentTbl + ", cognitoDynamoDbTagTbl="
				+ cognitoDynamoDbTagTbl + ", cognitoDynamoDbMmlWorkspace=" + cognitoDynamoDbMmlWorkspace
				+ ", cognitoDynamoDbOrgAccounts=" + cognitoDynamoDbOrgAccounts + ", cognitoDynamoDbUserAccounts="
				+ cognitoDynamoDbUserAccounts + ", cognitoDynamoDbUserSubscription=" + cognitoDynamoDbUserSubscription
				+ ", cognitoDynamoDbUserWallet=" + cognitoDynamoDbUserWallet + ", cognitoDynamoDbUserBilling="
				+ cognitoDynamoDbUserBilling + ", cognitoDynamoDbUserCredit=" + cognitoDynamoDbUserCredit + "]";
	}

	
	
}
