document.addEventListener("DOMContentLoaded", function() {
    var form = document.getElementById('productForm');

    form.addEventListener('submit', function(event) {
      var proid = document.getElementById("pid").value.trim();
      var pname = document.getElementById("pname").value.trim();
      var pprice = parseFloat(document.getElementById("pprice").value.trim());
      var pbrand = document.getElementById("pbrand").value.trim();
      var pmadein = document.getElementById("pmadein").value.trim();
      var pmkddate = new Date(document.getElementById("pmkddate").value);
      var pexpdate = new Date(document.getElementById("pexpdate").value);

      var errors = [];

      if (proid === "") {
        errors.push("Please enter Product ID.");
      }

      if (pname === "") {
        errors.push("Please enter Product Name.");
      }

      if (isNaN(pprice) || pprice <= 0) {
        errors.push("Please enter a valid price greater than 0.");
      }

      if (pbrand === "") {
        errors.push("Please enter Product Brand.");
      }

      if (pmadein === "") {
        errors.push("Please enter Product Made In.");
      }

      if (pmkddate.toString() === "Invalid Date") {
        errors.push("Please enter a valid Manufacture Date.");
      }

      if (pexpdate.toString() === "Invalid Date") {
        errors.push("Please enter a valid Expiration Date.");
      } else if (pexpdate <= pmkddate) {
        errors.push("Expiration Date must be greater than Manufacture Date.");
      }

      if (errors.length > 0) {
        event.preventDefault();
        alert(errors.join("\n")); // Show alert popup with all error messages
      }
    });
  });
