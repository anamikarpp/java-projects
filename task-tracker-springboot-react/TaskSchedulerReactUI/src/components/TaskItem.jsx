export default function TaskItem({task,onDelete,onToggle}){
    return(
        <li style={{textDecoration:task.completed?'line-through':'none'}}>
            <input type="checkbox" checked={task.completed} onChange={onToggle}/>
            {task.title}
            <button onClick={onDelete}>Delete</button>
        </li>
    )
}