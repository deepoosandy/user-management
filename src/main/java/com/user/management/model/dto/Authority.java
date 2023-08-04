package com.user.management.model.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Authority
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-08-03T11:56:22.485324715Z[GMT]")


public class Authority   {
  @JsonProperty("role")
  private String role = null;

  @JsonProperty("authorties")
  @Valid
  private List<String> authorties = null;

  public Authority role(String role) {
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

  public Authority authorties(List<String> authorties) {
    this.authorties = authorties;
    return this;
  }

  public Authority addAuthortiesItem(String authortiesItem) {
    if (this.authorties == null) {
      this.authorties = new ArrayList<String>();
    }
    this.authorties.add(authortiesItem);
    return this;
  }

  /**
   * Get authorties
   * @return authorties
   **/
  @Schema(description = "")
  
    public List<String> getAuthorties() {
    return authorties;
  }

  public void setAuthorties(List<String> authorties) {
    this.authorties = authorties;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Authority authority = (Authority) o;
    return Objects.equals(this.role, authority.role) &&
        Objects.equals(this.authorties, authority.authorties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(role, authorties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Authority {\n");
    
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    authorties: ").append(toIndentedString(authorties)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
