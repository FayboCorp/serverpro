//Fabian

var taskID = 0;


function deleteTask(id) {

    var list = document.getElementById("ordered-task");
    var del = document.getElementById(id);
    console.log(del.id);
    list.removeChild(del);
}

function moveTop(id){

    var obj = document.getElementById("ordered-task");
    var swap = document.getElementById(id);
    var top = obj.firstElementChild;

    obj.insertBefore(swap, top);
}

//insertBefore and insertAfter
//nextSibling and previousSibling

function moveDown(id){

    var obj = document.getElementById("ordered-task");
    var swap = document.getElementById(id);
    if(swap.nextSibling != null){
      console.log("True");
      var down = swap.nextSibling;
      obj.insertBefore(down, swap);
    }
}

function moveUp(id){

    var obj = document.getElementById("ordered-task");
    var head = obj.firstChild;
    head = head.nextSibling;
    var prev;
    while(head != null){
        console.log(head.id);
        console.log(id);
        prev = head;
        head = head.nextSibling;
        if(head != null){
            if(head.id == id){
                obj.insertBefore(head,prev);
            }
        }
        
    }
}

function addTask() {

    var dropDown = document.createElement("SELECT");

    var topB = document.createElement("input");
    var upB = document.createElement("input");
    var downB = document.createElement("input");
    var editB = document.createElement("input");
    var garbageB = document.createElement("input");
    var sendB = document.createElement("input");

    var ol = document.getElementById("ordered-task");
    var li = document.createElement("li");

    li.setAttribute("style", "width: 300px; height: 100px; z-index: 100; " +
        "border-style: dashed; border-color: black;");
    li.setAttribute("id", taskID);
    taskID++;

    topB.setAttribute("type", "image");
    topB.setAttribute("src", "top.png");
    topB.setAttribute("style", "position: relative; right: 75px; top: 70px; width: 20px; height: 20px");
    topB.setAttribute("onclick", "moveTop(parentNode.id)");

    upB.setAttribute("type", "image");
    upB.setAttribute("src", "up.png");
    upB.setAttribute("style", "position: relative; right: 45px; top: 70px; width: 20px; height: 20px");
    upB.setAttribute("onclick", "moveUp(parentNode.id)");

    downB.setAttribute("type", "image");
    downB.setAttribute("src", "down.png");
    downB.setAttribute("style", "position: relative; right: 15px; top: 70px; width: 20px; height: 20px");
    downB.setAttribute("onclick", "moveDown(parentNode.id)");

    editB.setAttribute("type", "image");
    editB.setAttribute("src", "edit.png");
    editB.setAttribute("style", "position: relative; left: 15px; top: 70px; width: 20px; height: 20px");

    garbageB.setAttribute("type", "image");
    garbageB.setAttribute("src", "garbage.png");
    garbageB.setAttribute("style", "position: relative; left: 45px; top: 70px; width: 20px; height: 20px");
    garbageB.setAttribute("onclick", "deleteTask(parentNode.id)");

    sendB.setAttribute("type", "image");
    sendB.setAttribute("src", "air plane.png");
    sendB.setAttribute("style", "position: relative; left: 75px; top: 70px; width: 20px; height: 20px");
    sendB.setAttribute("onclick", "popUpMsg(parentNode.id)"); //ADDED

    li.appendChild(topB);
    li.appendChild(upB);
    li.appendChild(downB);
    li.appendChild(editB);
    li.appendChild(garbageB);
    li.appendChild(sendB);

    var task = createTaskObject();
    var taskB = document.createElement("p");
    taskB.setAttribute("id", "taskText");
    taskB.innerHTML = "Task: " + task.taskMessage + "<br>" +  "  User: " + task.creator + "  Time: " + task.timeCreated;
    //taskB.setAttribute("value", task.taskMessage);
    //taskB.setAttribute("type", "button");

    li.appendChild(taskB);

    ol.appendChild(li);

}


function createTaskObject() {
    var message = document.getElementById("userIn").value;
    document.getElementById("userIn").value = "";

    var task = {

        taskMessage: message,
        timeCreated: "Now",
        creator: "User"

    }
    return task;
}

function handleKeyPress(e){
 var key=e.keyCode || e.which;
  if (key==13){
     addTask();
  }
}

function popUpMsg(e){
    confirm("Send task to other user?");
    deleteTask(e);
}