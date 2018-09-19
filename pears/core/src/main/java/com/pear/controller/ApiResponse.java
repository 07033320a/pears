package com.pear.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.Map;
import java.util.Objects;

/**
 * ApiResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-09-12T04:53:15.548Z")
@Data
public class ApiResponse {
  @JsonProperty("code")
  private Integer code = null;

  @JsonProperty("data")
  private Map<String,Object> data = null;

  public ApiResponse code(Integer code) {
    this.code = code;
    return this;
  }

  public ApiResponse data(Map<String,Object> data) {
    this.data = data;
    return this;
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

