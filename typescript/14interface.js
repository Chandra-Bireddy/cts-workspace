function print(v) {
    console.log(v.toString());
}
var p1 = {
    name: "Dachepalli Srinivas",
    age: 53,
    toString: function () {
        return this.name + " : " + this.age;
    }
};
print(p1);
var s1 = {
    name: "Sowmya",
    age: 20,
    course: "Angular",
    toString: function () {
        return this.name + " - " + this.age + " - " + this.course;
    }
};
print(s1);
