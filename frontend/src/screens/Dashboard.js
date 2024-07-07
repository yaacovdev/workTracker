import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getDailyWork } from "src/store/actions/dailyWork.action";

const Dashboard = () => {
    const dispatch = useDispatch();
    useEffect(() => {
        dispatch(getDailyWork());
    }, [dispatch]);

    const dailyWork = useSelector((state) => state.dailyWork.dailyWork);
    const username = dailyWork.length > 0 ? dailyWork[0].user.username : "";
    return (
        <div className="container mx-auto px-4">
            <h1 className="text-2xl font-bold mb-4 capitalize"> {username} dashboard</h1>
            <h2 className="text-xl font-bold mb-4">Daily Work</h2>
            <div className="overflow-x-auto">
                <table className="min-w-full bg-white shadow-md rounded-lg overflow-hidden">
                    <thead>
                        <tr className="bg-gray-800 text-white">
                            <th className="w-1/2 py-3 px-4 uppercase font-semibold text-sm">Date</th>
                            <th className="w-1/2 py-3 px-4 uppercase font-semibold text-sm">Hours Worked</th>
                        </tr>
                    </thead>
                    <tbody>
                        {dailyWork.map((work) => (
                            <tr key={work.id} className="text-gray-700">
                                <td className="w-1/2 py-3 px-4">{work.date}</td>
                                <td className="w-1/2 py-3 px-4">{work.hoursWorked}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default Dashboard;
