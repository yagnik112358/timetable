function saveOnClick(){

    html2canvas(document.getElementById("timetable"),
        {
            onrendered : function (canvas){

                let image = canvas.toDataURL("image/jpeg");
                let doc = new jsPDF();
                let width = 180;
                let height = 120;
                doc.addImage(image,'JPEG',15,15,width,height);
                doc.save('Timetable.pdf');
            }
        });
}