package com.user.management.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Authorities
 */
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-08-04T06:09:10.608841297Z[GMT]")


public class Authorities   {
  @JsonProperty("role")
  private String role = null;

  @JsonProperty("roleId")
  private Integer roleId = null;

  @JsonProperty("authorties")
  @Valid
  private List<Authority> authorties = null;

  public Authorities role(String role) {
    this.role = role;
    return this;
  }

  /**
   * Get role
   * @return role
   **/
  @Schema(description = "")
  
    public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public Authorities roleId(Integer roleId) {
    this.roleId = roleId;
    return this;
  }

  /**
   * Get roleId
   * @return roleId
   **/
  @Schema(description = "")
  
    public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }

  public Authorities authorties(List<Authority> authorties) {
    this.authorties = authorties;
    return this;
  }

  public Authorities addAuthortiesItem(Authority authortiesItem) {
    if (this.authorties == null) {
      this.authorties = new ArrayList<Authority>();
    }
    this.authorties.add(authortiesItem);
    return this;
  }

  /**
   * Get authorties
   * @return authorties
   **/
  @Schema(description = "")
      @Valid
    public List<Authority> getAuthorties() {
    return authorties;
  }

  public void setAuthorties(List<Authority> authorties) {
    this.authorties = authorties;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Authorities authorities = (Authorities) o;
    return Objects.equals(this.role, authorities.role) &&
        Objects.equals(this.roleId, authorities.roleId) &&
        Objects.equals(this.authorties, authorities.authorties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(role, roleId, authorties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Authorities {\n");
    
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    roleId: ").append(toIndentedString(roleId)).append("\n");
    sb.append("    authorties: ").append(toIndentedString(authorties)).append("\n");
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
