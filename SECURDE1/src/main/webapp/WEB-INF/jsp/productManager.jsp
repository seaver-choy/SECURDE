﻿<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8">

  <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script type="text/javascript" src="materialize/js/jquery.validate.js"></script>
  <script type="text/javascript" src="materialize/js/materialize.min.js"></script>
  <link rel="stylesheet" type="text/css" href="materialize/css/materialize.min.css">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <style type="text/css">
  label {
      width: 100%;
  }

  input{
    color: black;
  }

  textarea{
    color: black;
  }
  </style>
  <title></title>
  <script type="text/javascript">//<![CDATA[
    $(document).ready(function(){
        // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
        $('.modal-trigger').leanModal();
      });


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
      background: url('resources/minimalbackground.jpg') no-repeat center center fixed;
      background-color: rgba(0, 0, 0, 0.9 );
     -webkit-background-size: cover;
     -moz-background-size: cover;
     -o-background-size: cover;
     background-size: cover;
     margin: 0;

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

       .tableCss{
         color: #E2D893;
       }


  </style>
</head>
<body>
  <div class = "layer">
  <nav class = "transparent z-depth-0">
    <div class="nav-wrapper">
      <a href="#" class="brand-logo" style="padding-left: 10px;">KickAJ</a>
        <a id="nav-mobile" class="right hide-on-med-and-down" style="padding-right: 10px"> Welcome! PRODUCT MANAGER </a>
    </div>
  </nav>
  <div class="container">

    <table class = "bordered centered tableCss">
          <thead>
            <tr>
                <th data-field="id">Product ID</th>
                <th data-field="name">Product</th>
                <th data-field="price">Price</th>
            </tr>
          </thead>

          <tbody>
            <tr>
              <td>0000000000001</td>
              <td>Eclair</td>
              <td>$99999999</td>
              <td><a href="#modal1" class="modal-trigger"> <i class="material-icons">mode_edit</i></a></td>
              <td><a href="your link here"> <i class="material-icons">delete</i></a></td>
            </tr>
          </tbody>
        </table>
</div>
<div class="hiddendiv common"></div>
</div>
<div id="modal1" class="modal">
  <div class="modal-content">
    <h4 style= "color: black">Edit Product</h4>
    <form id="formValidate" class="col s12" novalidate="novalidate">
        <div class="row">
            <div class="input-field col s12">
                <input id="productNameField" name="productNameField"  type="text" required="" aria-required="true">
                <label for="productNameField">Product Name</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
              <textarea id="productDescriptionField" name="productDescriptionField"class="materialize-textarea"></textarea>
                <label for="productDescriptionField">Description</label>
            </div>
        </div>

        <div class ="row">
          <div class="input-field col s6">
            <select>
              <option value="" disabled selected>Select Category</option>
              <option value="1">Boots</option>
              <option value="2">Shoes</option>
              <option value="3">Sandals</option>
              <option value="4">Slippers</option>
            </select>
            <label>Role</label>
          </div>
          <div class="input-field col s6">
              <input id="productPriceField" name="productPriceField"  type="text" required="" aria-required="true">
              <label for="productPriceField">Price</label>
          </div>

        </div>
        <div class="hiddendiv common"></div>


  </div>
  <div class="modal-footer">
    <a type="submit" class=" modal-action modal-close waves-effect waves-green btn-flat">Done</a>
  </div>

  </form>
</div>
</body>
</html>
