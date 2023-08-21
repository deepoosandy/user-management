package com.user.management.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * InlineResponse200
 */
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-08-04T06:09:10.608841297Z[GMT]")


public class InlineResponse200   {
  @JsonProperty("users")
  @Valid
  private List<ListOfUsers> users = null;

  @JsonProperty("totalPage")
  private Integer totalPage = null;

  @JsonProperty("totalRecords")
  private Integer totalRecords = null;

  public InlineResponse200 users(List<ListOfUsers> users) {
    this.users = users;
    return this;
  }

  public InlineResponse200 addUsersItem(ListOfUsers usersItem) {
    if (this.users == null) {
      this.users = new ArrayList<ListOfUsers>();
    }
    this.users.add(usersItem);
    return this;
  }

  /**
   * Get users
   * @return users
   **/
  @Schema(description = "")
      @Valid
    public List<ListOfUsers> getUsers() {
    return users;
  }

  public void setUsers(List<ListOfUsers> users) {
    this.users = users;
  }

  public InlineResponse200 totalPage(Integer totalPage) {
    this.totalPage = totalPage;
    return this;
  }

  /**
   * This shows count of pages. 
   * @return totalPage
   **/
  @Schema(description = "This shows count of pages. ")
  
    public Integer getTotalPage() {
    return totalPage;
  }

  public void setTotalPage(Integer totalPage) {
    this.totalPage = totalPage;
  }

  public InlineResponse200 totalRecords(Integer totalRecords) {
    this.totalRecords = totalRecords;
    return this;
  }

  /**
   * Total records returned in this request. 
   * @return totalRecords
   **/
  @Schema(description = "Total records returned in this request. ")
  
    public Integer getTotalRecords() {
    return totalRecords;
  }

  public void setTotalRecords(Integer totalRecords) {
    this.totalRecords = totalRecords;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse200 inlineResponse200 = (InlineResponse200) o;
    return Objects.equals(this.users, inlineResponse200.users) &&
        Objects.equals(this.totalPage, inlineResponse200.totalPage) &&
        Objects.equals(this.totalRecords, inlineResponse200.totalRecords);
  }

  @Override
  public int hashCode() {
    return Objects.hash(users, totalPage, totalRecords);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200 {\n");
    
    sb.append("    users: ").append(toIndentedString(users)).append("\n");
    sb.append("    totalPage: ").append(toIndentedString(totalPage)).append("\n");
    sb.append("    totalRecords: ").append(toIndentedString(totalRecords)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
