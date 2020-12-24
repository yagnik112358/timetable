let tableFromJson = () => {
    let data = sessionStorage.getItem("jsonstring");
    console.log(data);
    const myData = JSON.parse(data);
        const days = [{name:"Monday"},{name:"Tuesday"},{name:"Wednesday"},{name:"Thursday"},{name:"Friday"}]
        // const myData = {
        //     courses:[
        //         {
        //             specialisation:[{name:"TSCD"}],
        //             name:"Algorithm",
        //             time:"4:00",
        //             day:"Monday",
        //             ta:[],
        //             room:"LT5",
        //             faculty:"VN MURLIDHARA"},
        //         {
        //             specialisation:[{name:"TSCD"}],
        //             name:"Algorithm",
        //             time:"4:00",
        //             day:"Tuesday",
        //             ta:[],
        //             room:"LT5",
        //             faculty:"VN MURLIDHARA"},
        //         {
        //             specialisation:[{name:"AI"}],
        //             name:"Software Systems",
        //             time:"2:00",
        //             day:"Tuesday",
        //             ta:[{
        //                     courses:[],
        //                     last_name:"Agarwal",
        //                     first_name:"Shubham",
        //                     email:"shubham.agarwal@iiitb.org"
        //                  }],
        //             room:"LT5",
        //             faculty:"B Thangaraju"},
        //         {
        //             specialisation:[{name:"AI"}],
        //             name:"Software Systems",
        //             time:"4:00",
        //             day:"Friday",
        //             ta:[{
        //                 courses:[],
        //                 last_name:"Agarwal",
        //                 first_name:"Shubham",
        //                 email:"shubham.agarwal@iiitb.org"
        //             }],
        //             room:"LT5",
        //             faculty:"B Thangaraju"},
        //         {
        //             specialisation: [{name: "AI"}],
        //             name: "Maths for Ml",
        //             time: "2:00",
        //             day: "Thursday",
        //             ta: [],
        //             room: "L33",
        //             faculty: "T Vishwanath"
        //         },
        //         {
        //             specialisation: [{name: "AI"}],
        //             name: "Maths for Ml",
        //             time: "9:00",
        //             day: "Friday",
        //             ta: [],
        //             room: "L34",
        //             faculty: "T Vishwanath"
        //         },
        //         {
        //             specialisation:[{name:"AI"}],
        //             name:"Software Systems",
        //             time:"2:00",
        //             day:"Monday",
        //             ta:[{
        //                         courses:[],
        //                         last_name:"Agarwal",
        //                         first_name:"Shubham",
        //                         email:"shubham.agarwal@iiitb.org"
        //                  }],
        //             room:"LT5",
        //             faculty:"B Thangaraju"}]
        // }
        let week="";
        week+="<thead><tr>";
        week+="<th><h1>Time</h1></th>";
        for(let i =0;i<days.length;i++){
            week+="<th><h1>";
            week+= days[i].name;
            week+="</th></h1>";
        }
        week+="</tr></thead>";
        // document.getElementById("daysOfWeek").innerHTML=week;
        let body= week;
        let times = [{time:"9:00"},{time:"11:00"},{time:"2:00"},{time:"4:00"}]
        let k=myData.courses;
        body+="<tbody id = 'tablebody' >";
        for (let t=0;t<times.length;t++) {
            body+="<tr>";
            body = body+"<td>"+times[t].time+"</td>";
            for(let m = 0;m<days.length;m++) {
                let flag =false;
                for (let i = 0; i < k.length; i++) {
                    let j = k[i].time;
                    let d = k[i].day;
                    if (j === times[t].time && d === days[m].name) {
                        body += "<td><div class='tooltip'>";
                        body = body + k[i].name + "<br>" + k[i].faculty + "<br>" + k[i].room;
                        body= body + "<span class='tooltiptext'>"+"TA: ";
                        for(let a =0 ; a<k[i].ta.length;a++){
                            body=body+ k[i].ta[a].first_name +" "+k[i].ta[a].last_name+"<br>";
                        }
                        body+="Specialisation:";
                        for(let a =0 ; a<k[i].specialisation.length;a++){
                            body=body+ k[i].specialisation[a].name+"<br>";
                        }

                        //+k[i].ta[0].first_name + k[i].ta[0].last_name+"<br>"+k[i].specialisation[0].name+"</span>";
                        body += "</div></td>";
                        flag = true;
                    }

                }
                if(flag === false){
                        body = body + "<td> </td>";
                        console.log("t is " + t);
                }
            }
            body+="</tr>";
        }
        body+="</tbody>";

        document.getElementById("timetable").innerHTML = body;

}