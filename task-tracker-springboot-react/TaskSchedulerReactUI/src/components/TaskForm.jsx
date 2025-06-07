import { useState } from 'react';
import { createTask } from '../services/taskService';

export default function TaskForm({onSuccess}){
    const[title,setTitle] = useState('');

    const handleSubmit = async (e) =>{
        e.preventDefault();
        await createTask({title,completed:false});
        setTitle('');
        onSuccess();
    };

    return(
        <form onSubmit={handleSubmit}>
            <input
            type="text"
            placeholder='New task'
            value={title}
            onChange={(e)=>setTitle(e.target.value)}
            required
            />
            <button type="submit">Add</button>
        </form>
    )
}