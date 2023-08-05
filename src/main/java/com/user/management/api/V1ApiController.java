package com.user.management.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.management.model.dto.*;
import com.user.management.service.AuthorityService;
import com.user.management.service.RoleAuthorityMappingService;
import com.user.management.service.RoleService;
import com.user.management.service.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-08-04T06:09:10.608841297Z[GMT]")
@RestController
public class V1ApiController implements V1Api {

    private static final Logger log = LoggerFactory.getLogger(V1ApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleAuthorityMappingService roleAuthorityMappingService;

    @org.springframework.beans.factory.annotation.Autowired
    public V1ApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<User> fetchUserById(@Parameter(in = ParameterIn.PATH, description = "This is userId. ", required = true, schema = @Schema()) @PathVariable("userId") String userId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Authority>> listAllAuthorties() {
        return new ResponseEntity<List<Authority>>(authorityService.listAllAuthorities(), HttpStatus.OK);
    }

    public ResponseEntity<List<Role>> listAllRoles() {
        return new ResponseEntity<List<Role>>(roleService.listAllRole(), HttpStatus.OK);
    }

    public ResponseEntity<RoleAndAuthorityMapping> listAuthoritiesAndRoleMapping() {
        return new ResponseEntity<RoleAndAuthorityMapping>(roleAuthorityMappingService.listAllRoleAuthorityMapping(), HttpStatus.OK);
    }

    public ResponseEntity<String> showLatestJwt() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<String>(objectMapper.readValue("\"\"", String.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<String>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Authorities>> updateAuthories(@Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema())
                                                             @Valid @RequestBody List<Authorities> body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            body = roleAuthorityMappingService.updateAuthorityMapping(body);
        }
        return new ResponseEntity<List<Authorities>>(body, HttpStatus.OK);
    }

    public ResponseEntity<Void> updateUserName(@Parameter(in = ParameterIn.PATH, description = "This is userId. ", required = true, schema = @Schema()) @PathVariable("userName") String userName, @Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Valid @RequestBody User body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> v1UserPost(@Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Valid @RequestBody User body) {
        String accept = request.getHeader("Accept");
        userService.createUser(body);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<InlineResponse200> v1UsersGet(@Parameter(in = ParameterIn.QUERY, description = "Maximum number of items to return ", schema = @Schema(defaultValue = "20")) @Valid @RequestParam(value = "page[limit]", required = false, defaultValue = "20") Integer pageLimit, @Parameter(in = ParameterIn.QUERY, description = "Max size of returned list.  ", schema = @Schema(defaultValue = "0")) @Valid @RequestParam(value = "page[offset]", required = false, defaultValue = "0") Integer pageOffset, @Parameter(in = ParameterIn.QUERY, description = "The ordering of the returned list. ", schema = @Schema(defaultValue = "displayName")) @Valid @RequestParam(value = "orderBy", required = false, defaultValue = "displayName") String orderBy) {
        List<User> users = userService.listAllUsers();
        InlineResponse200 inlineResponse200 = new InlineResponse200();
        ArrayList<ListOfUsers> list = new ArrayList<>();
        list.add(userService.listAllUsers());
        inlineResponse200.setUsers(list);
        return new ResponseEntity<InlineResponse200>(inlineResponse200, HttpStatus.OK);
    }

}
