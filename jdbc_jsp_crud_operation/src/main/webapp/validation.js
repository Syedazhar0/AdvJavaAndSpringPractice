document.getElementById("productForm").addEventListener("submit", function(event) {
    event.preventDefault();
    
    var pid = document.getElementById("pid").value.trim();
    var pname = document.getElementById("pname").value.trim();
    var pprice = document.getElementById("pprice").value.trim();
    var pbrand = document.getElementById("pbrand").value.trim();
    var pmadein = document.getElementById("pmadein").value.trim();
    var pmfddate = document.getElementById("pmfddate").value.trim();
    var pexpDate = document.getElementById("pexpDate").value.trim();
    
    if (!pid || !pname || !pprice || !pbrand || !pmadein || !pmfddate || !pexpDate) {
        alert("All fields must be filled!");
        return;
    }
    
    if (pname.length > 50 || pbrand.length > 50) {
        alert("Product name and brand must not exceed 50 characters!");
        return;
    }
    
    if (parseInt(pprice) <= 0) {
        alert("Price must be greater than zero!");
        return;
    }
    
    var mfdDate = new Date(pmfddate);
    var expDate = new Date(pexpDate);
    
    if (expDate <= mfdDate) {
        alert("Expiry date must be greater than manufacturing date!");
        return;
    }
    
    // If all validations pass, you can submit the form
    document.getElementById("productForm").submit();
});
