<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
﻿<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8">

  <spring:url value ="/resources/materialize.min.css" var="mainCss"/>
  <spring:url value ="/resources/materialize.min.js" var="mainJs"/>
  <spring:url value ="/resources/jquery.validate.min.js" var="valiJs"/>
  <spring:url value ="/resources/minimalbackground.jpg" var="backgroundimage"/>
  
  <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script type="text/javascript" src="${valiJs}"></script>
  <script type="text/javascript" src="${mainJs}"></script>
  <link rel="stylesheet" type="text/css" href="${mainCss}">
  <style type="text/css">
    /** FIXES for error messages https://github.com/Dogfalo/materialize/issues/1562*/
    label {
        width: 100%;
    }

  </style>
  
  <script type="text/javascript">//<![CDATA[
    $(window).load(function(){
    // Extension pour comptabilité avec materialize.css
    $.validator.setDefaults({
        errorClass: 'invalid',
        validClass: "valid",
        errorPlacement: function (error, element) {
            $(element)
                .closest("form")
                .find("label[for='" + element.attr("id") + "']")
                .attr('data-error', error.text());
        },
        submitHandler: function (form) {
            console.log('form ok');
        }
    });

    $.validator.addMethod("loginRegex", function(value, element) {
        return this.optional(element) || /^[a-z0-9\-\s]+$/i.test(value);
    }, "Username must contain only letters, numbers, or dashes.");

    $("#formValidate").validate({
        rules: {
            dateField: {
                date: true
            },
            usernameField: {
            	loginRegex: true,
              minlength: 5
            },
            passwordField: {
				required: true ,
				minlength: 6
			},
			confirmPasswordField: {
				required: true,
				minlength: 6,
				equalTo: "#passwordField"
			},
      firstNameField:{
        required: true,
        loginRegex:true
      },
      lastNameField:{
        required: true,
        loginRegex:true
      }
        }
    });
    });//]]>

    $(document).ready(function() {
    $('select').material_select();
  });

  </script>

  <style>
      body {
      background: url('${backgroundimage}') no-repeat center center fixed;
      background-color: rgba(0, 0, 0, 0.9 );
     -webkit-background-size: cover;
     -moz-background-size: cover;
     -o-background-size: cover;
     background-size: cover;
     margin: 0;

      }

      .input-field label {
        color: #E2D893;
      }
      .input-field input[type=text]:focus + label {
         color: #A79E65;
       }

       .input-field input[type=text]:focus {
         border-bottom: 1px solid #A79E65;
         box-shadow: 0 1px 0 0 #A79E65;
       }

       h2 {
         color: #f3e5f5;
       }

       .test{
           color: #f3e5f5;
       }

       div {
           color: #f3e5f5;
       }

       .layer {
           background-color: rgba(0, 0, 0, 0.7);
           position: absolute;
           top: 0;
           left: 0;
           width: 100%;
           height: 110%;
       }


  </style>
</head>
<body>
  <c:url value = "/j_spring_security_logout" var ="logoutUrl" />
   
  <div class = "layer">
  <nav class = "transparent z-depth-0">
    <div class="nav-wrapper">
      <a href="#" class="brand-logo" style="padding-left: 10px;">KickAJ</a>
        <a id="nav-mobile" class="right hide-on-med-and-down" style="padding-right: 10px"> Welcome! ADMIN </a>
    </div>
  </nav>
  <div class="container">
    <div class="valign-wrapper" style="height: 90%; width: 100%">
    <div class = "container valign">
    <div class="row">

    <form id="formValidate" class="col s12" novalidate="novalidate">
        <div class="row">
            <div class="input-field col s12">
                <input id="usernameField" name="usernameField"  type="text" required="" aria-required="true">
                <label for="usernameField">Username</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s6">

        <input id="firstNameField" name = "firstNameField" type="text" required="" aria-required="true">
        <label for="firstNameField">First Name</label>

            </div>
            <div class="input-field col s6">

        <input id="lastNameField" name = "lastNameField" type="text" required="" aria-required="true">
        <label for="lastNameField">Last Name</label>

            </div>
        </div>
        <div class="row">
          <div class="input-field col s6">
            <input id="passwordField" name="passwordField" type="password" >
            <label for="passwordField">Password</label>
          </div>
          <div class="input-field col s6">
            <input id="confirmPasswordField" name = "confirmPasswordField" type="password" >
            <label for="confirmPasswordField">Confirm Password</label>
          </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <input id="emailField" name="emailField" type="email" required="" aria-required="true">
                <label for="emailField">Email</label>
            </div>
        </div>
        <div class ="row">
          <div class="input-field col s12">
            <select>
              <option value="" disabled selected>Select Role for this account</option>
              <option value="1">Transaction Manager</option>
              <option value="2">Product Manager</option>
            </select>
            <label>Role</label>
          </div>

        </div>
        <div class="row">
            <div class="input-field col s12">
                <button class="btn waves-effect waves-light" type="submit" name="action"> Create Account </button>
            </div>
        </div>
    </form>
  </div>
  </div>
  </div>
</div>
<div class="hiddendiv common"></div>
</div>
  </body>
</html>
