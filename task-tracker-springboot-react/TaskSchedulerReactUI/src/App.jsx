import TaskList from "./components/TaskList";

export default function App(){
  return(
    <div style={{padding:'2rem'}}>
      <h1 style={{textAlign:"center"}}>Task Scheduler</h1>
      <TaskList/>
    </div>
  )
}