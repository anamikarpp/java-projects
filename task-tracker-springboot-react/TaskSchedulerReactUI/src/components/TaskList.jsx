import { useEffect, useState } from 'react';
import { getTasks, deleteTask, updateTask } from '../services/taskService';
import TaskForm from './TaskForm';
import TaskItem from './TaskItem';

export default function TaskList()
{
    const[tasks,setTasks] = useState([]);

    const loadTasks = async() =>{
        const data = await getTasks();
        setTasks(data);
    }

    useEffect(()=>{
        loadTasks();
    },[]);

    const handleDelete = async (id) =>{
        await deleteTask(id);
        loadTasks();
    };

    const handleToggle = async (task)=>{
        await updateTask(task.id,{...task,completed:!task.completed});
        loadTasks();
    }

    return(
        <div className='container'>
            <h2 style={{textAlign:"center"}}>Task List</h2>
            <TaskForm onSuccess={loadTasks}/>
            <ul>
                {tasks.map((task)=>(
                    <TaskItem
                      key={task.id}
                      task={task}
                      onDelete={()=>handleDelete(task.id)}
                      onToggle={()=>handleToggle(task)}
                    />
                ))}
            </ul>
        </div>
    )

};